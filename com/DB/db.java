//java -classpath "sqlite-jdbc-3.39.4.0.jar" db.java

package DB;
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
    private String[] tabTostr(String dane [][] )
    { 
        String[] result = new String[dane.length];
        for(int i=0;i<dane.length;i++)
        {
            result[i] = "";
            result[i] = result[i].concat("(");
            for(int a=0;a<dane[i].length;a++)
            {
                result[i] = result[i].concat(dane[i][a] + ",");
                
            }
            
            result[i] = result[i].substring(0, result[i].length()-1).concat(")"); //replace last ',' with ')'
            
        }
        return result;
    }

    public boolean insert(String dane [][])
    {
        // String [][] dane = {{"6","24/02/2022","20.11","Blik","Hera koka hasz"}};
        String[] a = tabTostr(dane);
        for(String line:a)
        {
            System.out.println(line);
            String  statemaneString = String.format(this.model.INSERT,line);
            System.out.println(statemaneString);
            try 
            {
                Statement stmt = this.conn.createStatement();
                stmt.execute(statemaneString);
                
            }catch (SQLException e) {
                e.printStackTrace();
                return false;
                //e.printStackTrace();
            }
        }
        return true;
    }

    public String select(String dane)
    {
        if (dane.equals("")) dane = "1=1";
        String  statemaneString = String.format(this.model.SELECT,dane);
        try 
        {
            Statement stmt = this.conn.createStatement();
            ResultSet res = stmt.executeQuery(statemaneString);
            return resultToStr(res);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return "wyebalo selecta";
    }


    public String resultToStr(ResultSet rs)
    {
        //String result[][] = {{""}};
        String result = "";
        try {
            while(rs.next()) {
                result = result.concat(rs.getString("data"));
                result = result.concat(" ");
                result = result.concat(rs.getString("typ_transakcji"));
                result = result.concat(" ");
                result = result.concat(rs.getString("opis"));
                result = result.concat(" ");
                result = result.concat(rs.getString("kwota"));
                result = result.concat(" ");
                
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return "wyebalo konwerter";
        }
    }


}

