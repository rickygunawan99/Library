package Controllers;

import Entity.CashierEntity;
import Entity.RentBookEntity;
import Model.CashierModel;
import views.HomeCashierView;

public class HomeCashierController implements Viewable{
    private final int id;
    HomeCashierView homeCashierView;

    public HomeCashierController(int id){
        this.id = id;
    }

    public CashierEntity getCurrentCashier(){
        return new CashierModel().getCurrentCashier(id);
    }

    public int insertListTable(RentBookEntity rentBook){
        return new CashierModel().insertListTable(rentBook);
    }

    @Override
    public void view() {
        if(homeCashierView == null){
            homeCashierView = new HomeCashierView(id);
        }
        homeCashierView.setVisible(true);
    }

}
