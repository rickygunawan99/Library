package Model;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.MemberEntity;

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
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
        }
        return -1;
    }
}
