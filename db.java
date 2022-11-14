//java -classpath "sqlite-jdbc-3.39.4.0.jar" db.java

package DB;
import java.sql.*;

public class db {


    String path = "wydatki.db";
    final String url = "jdbc:sqlite:DB/".concat(path);
    private Connection conn = null;
    private final db_model model = new db_model(); 
    
    public boolean connect() {    
        
        try {
            // create a connection to the database
            this.conn = DriverManager.getConnection(this.url);
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
            if (this.conn != null) {
                this.conn.close();
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

