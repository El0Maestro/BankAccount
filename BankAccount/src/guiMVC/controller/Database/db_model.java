package guiMVC.controller.Database;

public class db_model {
    String init  = "CREATE TABLE IF NOT EXIST transakcje( id integer PRIMARY KEY AUTOINCREMENT, data date, kwota decimal, typ_transakcji char(50), opis char(100))";
}