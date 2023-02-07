import DB.db;
public class Main {

    public static void main(String[] args) {
        db baza = new db();
        if (!baza.connect()) return;
        baza.init();
        String [][] dane = {{"24.02.2022","20.11","Blik","Hera koka hasz"},{"25/02/2022","4.20","Przelew","Twoja mama"}};
        if (baza.insert(dane))
        System.out.println(baza.select("1=1"));
        else
        System.out.println("nie dało rady wyciagnąc z bazy");
    }
}