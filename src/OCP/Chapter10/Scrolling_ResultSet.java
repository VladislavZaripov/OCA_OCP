package OCP.Chapter10;
import java.sql.*;
/*****************************************************************************************/
public class Scrolling_ResultSet {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        Statement stat = conn.createStatement
                            (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stat.executeQuery("select id from animal order by id");

        System.out.println(rs.absolute(2)  +" "+ rs.getInt("id"));          // true 2
        System.out.println(rs.absolute(-1) +" "+ rs.getInt("id"));          // true 5
        rs.afterLast();                             // rs.getInt("id") throw SQLException
        rs.beforeFirst();                           // rs.getInt("id") throw SQLException
        System.out.println(rs.first() +" "+ rs.getInt("id"));               // true 1
        System.out.println(rs.last() +" "+ rs.getInt("id"));                // true 5
        System.out.println(rs.relative(-3) +" "+ rs.getInt("id"));          // true 2
        System.out.println(rs.next() +" "+ rs.getInt("id"));                // true 3
        System.out.println(rs.relative(2) +" "+ rs.getInt("id"));           // true 5
        System.out.println(rs.relative(2));                                 // false
        rs.beforeFirst(); System.out.println(rs.previous());                // false
        rs.afterLast(); System.out.println(rs.next());                      // false
    }}
