package Controllers;

import Entity.BookEntity;
import Model.BookModel;
import views.EditBookView;

public class EditBookController implements Viewable{

    private BookEntity book;

    public EditBookController(BookEntity book)
    {
        this.book = book;
    }
    @Override
    public void view() {
        new EditBookView(book).setVisible(true);
    }

    public int edit(){
       return new BookModel().updateBookLocation(book);
    }

    public int delete(String jumlah){
        return new BookModel().delete(book,jumlah);
    }
}
