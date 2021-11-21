package OCP.Chapter10;
import java.sql.*;
/*****************************************************************************************/
public class Closing_Database_Resources {
    public static void main(String[] args) throws SQLException {
    String url = " jdbc:derby:zoo";

    // try-with-resource statement close resource in the reverse order
    try (Connection conn = DriverManager.getConnection(url);            // close third
         Statement stmt = conn.createStatement();                       // close second
         ResultSet rs1 = stmt.executeQuery("select name from animal"))   // close first
    { while (rs1.next()) System.out.println(rs1.getString(1));

    // JDBC closes a ResultSet when you run another SQL statement from the same Statement
         ResultSet rs2 = stmt.executeQuery("select name from animal");

    // executeUpdate also close previous ResultSet
         int num = stmt.executeUpdate
                 ("update animal set name = 'clear' where name = 'other'");
    }}}
