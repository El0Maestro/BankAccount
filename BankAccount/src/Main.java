import guiMVC.controller.Excel;
import guiMVC.controller.DB;
import guiMVC.view.GUI;

public class Main {
    public static void main(String[] args) {

        Excel read = new Excel();
    }

    /*public static void main(String[] args) {
        db baza = new db();
        if (!baza.connect()) return;
        baza.init();
        String[][] dane = {{"Null", "'24/02/2022'", "20.11", "'Blik'", "'Hera koka hasz'"}};
        if (baza.insert(dane))
            System.out.println(baza.select("1=1"));
        else
            System.out.println("oops");
    }*/
}