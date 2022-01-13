package Controllers;

import Entity.CashierEntity;
import Entity.RentBookEntity;
import Model.CashierModel;
import views.InsertPinjamanView;

public class InsertPinjamanController implements Viewable{

    private final CashierEntity cashier;

    public InsertPinjamanController(CashierEntity cashier){
        this.cashier = cashier;
    }

    @Override
    public void view() {
        new InsertPinjamanView(cashier).setVisible(true);
    }

    public int insert(RentBookEntity rent){
        return new CashierModel().insertListTable(rent);
    }

    public int getIdPinjaman(){
        return new CashierModel().getIdPinjaman();
    }
}
