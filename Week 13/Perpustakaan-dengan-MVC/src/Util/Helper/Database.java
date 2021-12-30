package Util.Helper;

import java.sql.*;

public class Database {

    public static Connection getConnection()
    {
        String url = "jdbc:mysql://" + Config.DB_HOST  + "/" + Config.DB_NAME;
        String user = Config.DB_USER;
        String pass = Config.DB_PASS;

        try{
            Class.forName(Config.DB_DRIVER);

            Connection koneksi = DriverManager.getConnection(url,user,pass);

            return koneksi;

        }catch(Exception e){
            System.out.println(e + " | getConnection()");
            return null;
        }
    }

    public static Statement prepare(Connection conn){
        try {
            Statement stmt = conn.createStatement();
            return stmt;
        }catch (Exception e){
            System.out.println(e + " | error in Prepare");
            return null;
        }
    }

    public static ResultSet query(Statement stmt, String sql){
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }catch (Exception e){
            System.out.println(e + " | error in query");
            return null;
        }
    }
}
