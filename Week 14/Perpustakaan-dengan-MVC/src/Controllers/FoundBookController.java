package Controllers;

import Entity.BookEntity;
import Model.BookModel;
import views.FoundBookView;

public class FoundBookController implements Viewable{

    BookEntity book;

    public FoundBookController() {
    }

    public FoundBookController(BookEntity book){
        this.book = book;
    }

    @Override
    public void view() {
        new FoundBookView(book).setVisible(true);
    }

    public BookEntity getBook(String title){
        return new BookModel().getBook(title);
    }

}
