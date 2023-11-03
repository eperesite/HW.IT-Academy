package Engine;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static String database = "банк";

    private static String user = "root";

    private static String password = "2731Margo";

    public static Connection getConnection() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);

        return con;
    }
}