package Controllers;

import views.HomeView;

public class HomeController implements Viewable {

    @Override
    public void view() {
        new HomeView().setVisible(true);
    }
}
