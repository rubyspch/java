import java.sql.*;

public class Database {

    //This method executes a query and returns the number of albums for the artist with name artistName
    public int getTitles(String artistName) {
        int titleNum = 0;
        //Implement this method
        //Prevent SQL injections!
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(Credentials.URL, Credentials.USERNAME, Credentials.PASSWORD);
            String sql = "SELECT COUNT(*) FROM album INNER JOIN artist ON album.artistid = artist.artistid WHERE artist.name = ?";
            PreparedStatement prepst = con.prepareStatement(sql);
            prepst.setString(1, artistName);

            ResultSet rs = prepst.executeQuery();
            //titleNum = (int) rs.getObject("count");
            while(rs.next())
                titleNum = rs.getInt(1);

        } catch (Exception e){
            e.printStackTrace();
        }
        return titleNum;
    }

    // This method establishes a DB connection & returns a boolean status
    public boolean establishDBConnection() {
        //Implement this method

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(Credentials.URL, Credentials.USERNAME, Credentials.PASSWORD);
            return true;
        } catch(Exception e) {
            //5 sec timeout
            return false;
        }
    }
}