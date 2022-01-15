package Model;

import Entity.BookEntity;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookModel extends ModelAbstract{
    private String sql;
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
            JOptionPane.showMessageDialog(null,"Pencarian gagal, periksa koneksi terlebih dahulu");
        }
        return null;
    }

    public int addBook(BookEntity book, int exist)
    {
        if(exist != -1){
            return updateBook(exist);
        }

        sql = "INSERT INTO Books(kode,title,lokasi) VALUES ('%s', '%s', '%s')";
        sql = String.format(sql,book.getBookCode(),book.getName(),book.getLocation());

        return exUpdate(sql);
    }

    public int updateBook(int exist){
        sql = "SELECT * FROM books WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,exist);
            rs = ps.executeQuery();

            if(rs.next()){
                int currentStock = rs.getInt("tersedia");
                sql =  "UPDATE books SET tersedia = %d WHERE id = '%s' ";
                sql = String.format(sql, currentStock+1, exist);
                return exUpdate(sql);
            }
        }catch (SQLException e){
            System.out.println("Update gagal, periksa koneksi terlebih dahulu");
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
            System.out.println("Gagal select, gagal koneksi");
        }
        return -1;
    }

    public int updateBookLocation(BookEntity book){
        sql = "UPDATE books SET lokasi = '%s' WHERE kode = '%s'";
        sql = String.format(sql,book.getLocation(), book.getBookCode());

        return exUpdate(sql);
    }

    public int delete(BookEntity book, String jumlah) {
        int count = Integer.parseInt(jumlah);
        if (jumlah.equalsIgnoreCase("All") || book.getJmlTersedia() - count <= 0) {
            sql = " DELETE FROM books WHERE kode = '%s' ";
            sql = String.format(sql,book.getBookCode());
        } else {
            sql = " UPDATE books SET tersedia = %d WHERE kode = '%s' ";
            sql = String.format(sql, book.getJmlTersedia() - count, book.getBookCode());
        }
        return exUpdate(sql);
    }

    public int exUpdate(String format){
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(format);
        }catch (SQLException e){
            System.out.println("Update tidak berhasil, Cek koneksi kembali");
        }
        return -1;
    }
}

