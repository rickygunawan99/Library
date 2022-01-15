package Model;

import java.sql.*;

public abstract class ModelAbstract {
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement ps;
    protected ResultSet rs;

    protected void connect(){
        conn = Util.Helper.Database.getConnection();
    }
}
