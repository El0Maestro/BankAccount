package DB;
public class db_model {
    final String init  = """
        CREATE TABLE IF NOT EXISTS tranzakcje( 
            id integer PRIMARY KEY AUTOINCREMENT, 
            data varchar(30), 
            kwota varchar(10), 
            typ_transakcji varchar(50), 
            opis varchar(100))""";
    
    
    final String SELECT = """
            SELECT * FROM tranzakcje WHERE %s;
            """;

    final String INSERT = """
            INSERT INTO tranzakcje VALUES %s
            """;


}
