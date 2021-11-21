package OCP.Chapter10;
import java.sql.*;
import java.time.*;
import java.util.*;
/*****************************************************************************************/
public class Getting_Data_from_a_ResulSet {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        Statement stmt = conn.createStatement();
/*****************************************************************************************/
    // Iterate throw all rows
    ResultSet rs1 = stmt.executeQuery("select id, name from species");
    Map <Integer,String> idToNameMap = new HashMap<>();
    while (rs1.next()){
        int id = rs1.getInt("id");               // Can use number of column getInt(1).
        String name = rs1.getString("name");     // Can use number of column getInt(2).
        idToNameMap.put(id,name); }              // Columns counting from 1.
    System.out.println(idToNameMap);             // {1=African Elephant, 2=Zebra}
/*****************************************************************************************/
    // Take one row
    ResultSet rs2 = stmt.executeQuery("select count(*) from animal");
    if (rs2.next()) System.out.println(rs2.getInt(1));              // 5
/*****************************************************************************************/
    // Take DataTime
    ResultSet rs3 = stmt.executeQuery("select date_born from animal where name = 'Elsa'");
    if (rs3.next()){
        java.sql.Date sqlData = rs3.getDate(1);
        LocalDate localDate = sqlData.toLocalDate();
        System.out.println(localDate);                              // 2008-12-01

        java.sql.Time sqlTime = rs3.getTime(1);
        LocalTime localTime = sqlTime.toLocalTime();
        System.out.println(localTime);                              // 23:59:59

        java.sql.Timestamp sqlDateTime = rs3.getTimestamp(1);
        LocalDateTime localDateTime = sqlDateTime.toLocalDateTime();
        System.out.println(localDateTime);}                         // 2008-12-01T23:59:59

/*****************************************************************************************/
    // Take object
    ResultSet rs4 = stmt.executeQuery("select id, name from species");
    while (rs4.next()){                                                   /* Print */
        Object id = rs4.getObject("id");                               // 1
        Object name = rs4.getObject("name");                           // African Elephant
        if (id instanceof Integer) System.out.println((Integer)id);    // 2
        if (name instanceof String) System.out.println((String) name); // Zebra
}}}
