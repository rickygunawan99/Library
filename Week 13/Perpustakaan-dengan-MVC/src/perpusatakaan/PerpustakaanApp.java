package perpusatakaan;

import Controllers.VisitorController;
import Entity.BookEntity;
import Entity.VisitorEntity;
import views.CashierView;
import views.HomeView;
import views.MemberView;

import java.time.LocalDate;
import java.util.StringJoiner;

public class PerpustakaanApp {

    public static void main(String[] args) {
        new HomeView().setVisible(true);
    }
}
