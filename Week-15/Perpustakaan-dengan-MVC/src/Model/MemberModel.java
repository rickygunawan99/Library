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


    public MemberModel(){
        connect();
    }

    public int getMember(String no_ktp){
        sql = "SELECT * FROM members WHERE no_ktp = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,no_ktp);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("id");
        }catch (SQLException e){
            System.out.println("No ktp tidak ditemukan");
        }
        return -1;
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
            System.out.println("Data member tidak ditemukan");
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
            System.out.println("No ktp tidak dapat ditemukan");
        }
        return temp;
    }

    public int reg(MemberEntity vs){
        sql = "INSERT INTO members(name,no_ktp,adress) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vs.getName());
            ps.setString(2,vs.getIdKtp());
            ps.setString(3,vs.getAdress());

            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Register gagal, masukan data dengan tepat");
        }
        return -1;
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
}
