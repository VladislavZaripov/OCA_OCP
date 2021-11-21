package OCP.Chapter10;
import java.sql.*;
public class Connecting_to_a_Database {}
/*****************************************************************************************/
class GettingConnection1{
    public static void main(String[] args) throws SQLException {
        // Connection by DriverManager - do not recommend to use, simple version.
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        System.out.println(conn);

    //  Connection conn = DriverManager.getConnection(
    //  "jdbc:postgresql://localhost:5432/ocp-book","username","password");
    }}

class GettingConnection2{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // Having META-INF/service/java.sql.Driver inside the JAR became mandatory with
    // JDBC 4.0 in Java 6. Class.forName use for loading a class directly.
            Class.forName("org.apache.derby.jdbc.AutoloadedDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
            System.out.println(conn);
    }}

