package OCP.Chapter10;
import java.sql.*;
/*****************************************************************************************/
public class Executing_a_Statement {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        Statement stmt = conn.createStatement();
        int result;     // returns numbers of rows, which was inserted, deleted or changed.
        result = stmt.executeUpdate("insert into species values(10, 'Deer', 3)");
        System.out.println(result); // 1
        result = stmt.executeUpdate("update species set name = '' where name = 'None'");
        System.out.println(result); // 0
        result = stmt.executeUpdate("delete from species where id = 10");
        System.out.println(result); // 1
        ResultSet res = stmt.executeQuery("select * from animal");
        System.out.println(res);    // org.apache.derby.impl.jdbc.EmbedResultSet42@47af7f3d
    }}
