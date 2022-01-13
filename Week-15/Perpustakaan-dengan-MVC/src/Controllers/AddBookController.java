package Controllers;

import Entity.BookEntity;
import Model.BookModel;
import views.AddBookView;

public class AddBookController implements Viewable{
    private BookEntity book;

    public AddBookController() {
    }

    public AddBookController(BookEntity book){
        this.book = book;
    }

    public int addBook(){
        return new BookModel().addBook(book, new BookModel().existBook(book));
    }

    @Override
    public void view() {
        new AddBookView().setVisible(true);
    }
}
