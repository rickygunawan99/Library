package Model;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.MemberEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashierModel extends ModelAbstract{
    //Member

    public CashierModel(){
        connect();
    }


    public int login(String username , String password)
    {
        sql = "SELECT * FROM cashiers WHERE username = ? AND password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (SQLException e){
            System.out.println("Username dengan nama : " + username + " tidak ditemukan");
        }
        return -1;
    }

    public CashierEntity getCurrentCashier(int id){
        sql = "SELECT * FROM cashiers WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next())
                return new CashierEntity(
                        new MemberEntity(rs.getString("nama"),rs.getString("no_ktp"),
                                rs.getString("adress")),rs.getString("username"),
                        rs.getString("password")
                );
        }catch (SQLException e){
            System.out.println("Query gagal. Id tidak ada");
        }
        return null;
    }

    public int insertListTable(RentBookEntity rentBook){
        sql = "INSERT INTO list(kodeBuku,bookTitle,namaMember,noKtpMember,alamatMember,namaKasir,dayStart,dayEnd,total) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,rentBook.getBook().getBookCode());
            ps.setString(2,rentBook.getBook().getName());
            ps.setString(3,rentBook.getMember().getName());
            ps.setString(4,rentBook.getMember().getIdKtp());
            ps.setString(5,rentBook.getMember().getAdress());
            ps.setString(6,rentBook.getCashier().getCashier().getName());
            ps.setString(7,rentBook.getDayStart());
            ps.setString(8,rentBook.getDayEnd());
            ps.setInt(9,rentBook.getTotalPrice());

            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal menambahkan ke database, data tidak sesuai");
        }
        return -1;
    }

    public int getIdPinjaman(){
        sql = "SELECT * FROM list ORDER BY id DESC LIMIT 1";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
                return rs.getInt("id");
        }catch (Exception e){
            System.out.println("Query gagal, id masih kosong");
        }
        return -1;
    }
}
