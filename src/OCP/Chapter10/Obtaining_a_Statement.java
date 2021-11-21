package OCP.Chapter10;
import java.sql.*;
public class Obtaining_a_Statement {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");

        Statement stmt1 = conn.createStatement();
        Statement stmt2 = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY);
    }}

