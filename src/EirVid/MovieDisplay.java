package EirVid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;

public class MovieDisplay {
    public void printAllFilms() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE visionvibe");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

            while (rs.next()) {
                int movieID = rs.getInt("MovieID");
                String originalLanguage = rs.getString("OriginalLanguage");
                String title = rs.getString("Title");
                int popularity = rs.getInt("Popularity");
                double voteAverage = rs.getDouble("VoteAverage");
                double voteCount = rs.getDouble("VoteCount");
                double price = rs.getDouble("Price");

                System.out.println("MovieID: " + movieID);
                System.out.println("Title: " + title);
                System.out.println("Original Language: " + originalLanguage);
                System.out.println("Popularity: " + popularity);
                System.out.println("Vote Average: " + voteAverage);
                System.out.println("Vote Count: " + voteCount);
                System.out.println("Price: " + price);
                System.out.println("------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public void price_name_output(int movieID) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement("SELECT Title, Price FROM movies WHERE MovieID = ?")) {
            pstmt.execute("USE visionvibe");
            pstmt.setInt(1, movieID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                
                String title = rs.getString("Title");
                double price = rs.getDouble("Price");

                System.out.println("Movie Title: " + title + "Price: $" + price);
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }      
    }
}