
import DB.db;
public class Main {

    public static void main(String[] args) {
        db baza = new db();
        if (!baza.connect()) return;;
        
    }
}