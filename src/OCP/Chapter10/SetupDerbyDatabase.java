package OCP.Chapter10;
import java.sql.*;
public class SetupDerbyDatabase {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE species ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");
            stmt.executeUpdate(
                    "CREATE TABLE animal ("
                            + "id INTEGER PRIMARY KEY, "
                            + "species_id integer, "
                            + "name VARCHAR(255), "
                            + "date_born TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2008-12-01 23:59:59')");
            stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2008-12-02 23:59:59')");
            stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2008-12-03 23:59:59')");
            stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2008-12-04 23:59:59')");
            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2008-12-05 23:59:59')");
    }}}
//  INSERT: Add a new row to the table
//  SELECT: Retrieve data from the table
//  UPDATE: Change zero or more rows in the table
//  DELETE: Remove zero or more rows from the table

