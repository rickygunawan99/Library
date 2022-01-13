package Controllers;

import Entity.CashierEntity;
import Model.CashierModel;
import views.HomeCashierView;

public class HomeCashierController implements Viewable{
    private final int id;

    public HomeCashierController(int id){
        this.id = id;
    }

    public CashierEntity getCurrentCashier(){
        return new CashierModel().getCurrentCashier(id);
    }

    @Override
    public void view() {
        new HomeCashierView(id).setVisible(true);
    }

}
