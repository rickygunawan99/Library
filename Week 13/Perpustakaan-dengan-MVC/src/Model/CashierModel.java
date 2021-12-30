package Model;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.VisitorEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashierModel extends ModelAbstract{

    public CashierModel(){
        connect();
    }

    public int addBook(BookEntity book, int exist)
    {
        if(exist != -1){
            return updateBook(exist);
        }

        sql = "INSERT INTO Books(kode,title,lokasi) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookCode());
            ps.setString(2,book.getName());
            ps.setString(3,book.getLocation());
            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return -1;
    }

    public int updateBook(int exist){
        sql = "SELECT * FROM books WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,exist);
            rs = ps.executeQuery();

            if(rs.next()){
                int currentStock = rs.getInt("tersedia");
                sql =  "UPDATE books SET tersedia = ? WHERE id = ?";
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ps2.setInt(1,currentStock+1);
                ps2.setInt(2,exist);
                return ps2.executeUpdate();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        return -1;
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
                        new VisitorEntity(rs.getString("nama"),rs.getString("no_ktp"),
                                rs.getString("adress")),rs.getString("username"),
                        rs.getString("password")
                );
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public int insertListTable(RentBookEntity rentBook){
        sql = "INSERT INTO list(kodeBuku,bookTitle,namaVisitor,noKtpVisitor,alamatVisitor,namaKasir,dayStart,dayEnd,total) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,rentBook.getBook().getBookCode());
            ps.setString(2,rentBook.getBook().getName());
            ps.setString(3,rentBook.getVisitor().getName());
            ps.setString(4,rentBook.getVisitor().getIdKtp());
            ps.setString(5,rentBook.getVisitor().getAdress());
            ps.setString(6,rentBook.getCashier().getCashier().getName());
            ps.setString(7,rentBook.getDayStart());
            ps.setString(8,rentBook.getDayEnd());
            ps.setInt(9,rentBook.getTotalPrice());

            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal menambahkan ke database");
            System.out.println(e);
        }
        return -1;
    }

    public int existBook(BookEntity book){
        sql = "SELECT * FROM books WHERE title = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            rs = ps.executeQuery();

            if(rs.next())
                return rs.getInt("id");
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        return -1;
    }
}
