package Controllers;

import Entity.MemberEntity;
import Model.MemberModel;
import views.DaftarMemberView;

public class RegisterMemberController implements Viewable{

    public int reg(MemberEntity member){
        return new MemberModel().reg(member);
    }

    @Override
    public void view() {
        new DaftarMemberView().setVisible(true);
    }
}
