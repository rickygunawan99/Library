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

    public MemberEntity getMemberEntity(String no_ktp){
        return new MemberModel().getMemberEntity(no_ktp);
    }


    public DefaultTableModel getHistory(String no_ktp){
        return new MemberModel().getTable(no_ktp);
    }

    @Override
    public void view() {
        new MemberView(member).setVisible(true);
    }
}
