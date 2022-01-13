package Controllers;

import Model.CashierModel;
import views.LoginCashierView;

public class LoginCashierController implements Viewable{

    public int login(String username, String password){
        return new CashierModel().login(username,password);
    }

    @Override
    public void view() {
        new LoginCashierView().setVisible(true);
    }
}
