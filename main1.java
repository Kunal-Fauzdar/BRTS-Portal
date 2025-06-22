import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
public class main1 {
    public static Connection con;
    public static void main(String[] args)throws SQLException , FileNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/brts_portal";
        String dbuser = "root";
        String dbpassword = "";
        con = DriverManager.getConnection(dburl, dbuser, dbpassword);
        System.out.println((con != null)? "succesful":"failed");
        new loginPage();
        // String query = "select station_id from station_table where station_name = ?";
        // PreparedStatement pst = main1.con.prepareStatement(query);
        // String source = "ranip";
        // pst.setString(1, source);
        // ResultSet rs = pst.executeQuery();
        // while(rs.next())
        // {
        //     int source_station_id = rs.getInt(1);
        //     System.out.println(source_station_id);
        // }
       
        
        

    }
}
