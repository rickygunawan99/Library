package Model;

import Entity.BookEntity;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class BookModel extends ModelAbstract{
    public BookModel(){
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
        } catch (SQLIntegrityConstraintViolationException e){
            return -2;
        } catch (SQLException e){
            return -1;
        }
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

    public int updateBookLocation(BookEntity book){
        sql = "UPDATE books SET lokasi = ? WHERE kode = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getLocation());
            ps.setString(2,book.getBookCode());
            return ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return -1;
    }

    public int delete(BookEntity book, String jumlah){
        int count = Integer.parseInt(jumlah);
        if(jumlah.equalsIgnoreCase("All") || book.getJmlTersedia()-count<0){
            sql = "DELETE FROM books WHERE kode = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1,book.getBookCode());
                return ps.executeUpdate();
            }catch (SQLException e){
                System.out.println(e);
            }
        }else{
            sql = "UPDATE books SET tersedia = ? WHERE kode = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1,book.getJmlTersedia()-count);
                ps.setString(2,book.getBookCode());
                return ps.executeUpdate();
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return -1;
    }
}

