package Model;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.MemberEntity;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberModel extends ModelAbstract{
    private String sql;

    public MemberModel(){
        connect();
    }

    public MemberEntity getMemberEntity(String no_ktp){
        sql = "SELECT * FROM members WHERE no_ktp = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,no_ktp);
            rs = ps.executeQuery();

            if(rs.next()){
                return new MemberEntity(rs.getString("name"),rs.getString("no_ktp"),rs.getString("adress"));
            }
        }catch (SQLException e){
            System.out.println("Tidak dapat mencari member, cek kembali koneksi");
        }
        return null;
    }

    public List<RentBookEntity> getListTable(String no_ktp){
        sql = "SELECT * FROM list WHERE noKtpMember = ?";
        ArrayList<RentBookEntity> temp = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,no_ktp);
            rs = ps.executeQuery();

            if(rs.next()){
                RentBookEntity rent = new RentBookEntity(
                        new BookEntity(rs.getString("kodeBuku"),rs.getString("bookTitle")),
                        new CashierEntity(rs.getString("namaKasir")),
                        rs.getString("dayStart"),rs.getString("dayEnd"),rs.getInt("total"),
                        rs.getInt("denda"),rs.getInt("status")
                );
                temp.add(rent);
            }
        }catch (SQLException e){
            System.out.println("Query gagal, harap cek koneksi anda ");
        }
        return temp;
    }

    public int reg(MemberEntity member){
        sql = "INSERT INTO members(name,no_ktp,adress) VALUES ('%s', '%s', '%s')";
        sql = String.format(sql, member.getName(), member.getIdKtp(), member.getAdress());
        return exUpdate(sql);
    }

    public DefaultTableModel getTable(String no_ktp){
        DefaultTableModel table = new DefaultTableModel();
        Object[] column = {"Kode Buku", "Judul", "Tgl Pinjam", "Tgl Kembali", "Status", "Denda"};
        table.setColumnIdentifiers(column);
        List<RentBookEntity> rent = getListTable(no_ktp);
        for (RentBookEntity rentBook : rent) {
            Object[] row = new Object[6];
            row[0] = rentBook.getBook().getBookCode();
            row[1] = rentBook.getBook().getName();
            row[2] = rentBook.getDayStart();
            row[3] = rentBook.getDayEnd();
            row[4] = rentBook.getStatus();
            row[5] = rentBook.getDenda();
            table.addRow(row);
        }
        return table;
    }

    public int exUpdate(String sql){
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("Koneksi tidak berhasil, coba lagi");
        }
        return -1;
    }
}
