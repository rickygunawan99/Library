package Controllers;

import Entity.*;
import Model.MemberModel;
import views.*;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MemberController implements Viewable {

    private MemberEntity member;

    public MemberController() {
    }

    public MemberController(MemberEntity member){
        this.member = member;
    }


    public int getMember(String no_ktp){
        return new MemberModel().getMember(no_ktp);
    }

    public MemberEntity getMemberEntity(String no_ktp){
        return new MemberModel().getMemberEntity(no_ktp);
    }

    public List<RentBookEntity> getListTable(String no_ktp){
        return new MemberModel().getListTable(no_ktp);
    }

    public DefaultTableModel getHistory(String no_ktp){
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

    @Override
    public void view() {
        new MemberView(member).setVisible(true);
    }
}
