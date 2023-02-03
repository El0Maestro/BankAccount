package guiMVC.controller.Database;
import java.sql.*;

public class db {
    Connection conn = null;
    String path = "wydatki.db";
    final String url = "jdbc:sqlite:".concat(path);




    private final db_model model = new db_model();

    public boolean connect() {

        try {
            // create a connection to the database
            this.conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public void disconnect()
    {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void init()
    {
        String  statemaneString = this.model.init;
        try
        {
            Statement stmt = this.conn.createStatement();
            stmt.execute(statemaneString);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


}