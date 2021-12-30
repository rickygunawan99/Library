package Model;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.VisitorEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorModel extends ModelAbstract{


    public VisitorModel(){
        connect();
    }


    public BookEntity getBook(String title)
    {
        sql = "SELECT * FROM books WHERE title = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,title);

            rs = ps.executeQuery();
            if(rs.next()){
                return new BookEntity(rs.getString("kode"),
                        rs.getString("title"),rs.getInt("tersedia"),rs.getString("lokasi") );
            }
        }catch (SQLException e){
            System.out.println("Buku dengan judul " + title + " tidak ditemukan");
            System.out.println(e);
        }
        return null;
    }

    public int getVisitor(String no_ktp){
        sql = "SELECT * FROM visitors WHERE no_ktp = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,no_ktp);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("id");
        }catch (SQLException e){
            System.out.println("No ktp tidak ditemukan");
            System.out.println(e);
        }
        return -1;
    }

    public VisitorEntity getVisitorEntity(String no_ktp){
        sql = "SELECT * FROM visitors WHERE no_ktp = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,no_ktp);
            rs = ps.executeQuery();

            if(rs.next()){
                return new VisitorEntity(rs.getString("name"),rs.getString("no_ktp"),rs.getString("adress"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<RentBookEntity> getListTable(String no_ktp){
        sql = "SELECT * FROM list WHERE noKtpVisitor = ?";
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
            System.out.println(e);
        }
        return temp;
    }

    public int reg(VisitorEntity vs){
        sql = "INSERT INTO visitors(name,no_ktp,adress) VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vs.getName());
            ps.setString(2,vs.getIdKtp());
            ps.setString(3,vs.getAdress());

            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return -1;
    }
}
