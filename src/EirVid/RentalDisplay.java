/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;

/**
 *
 * @author Wellington 2021330
 */
public class RentalDisplay {
    public RentalDisplay(){       
    }
    
    public void get_movies_by_userID(int userId) {

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(
         "SELECT m.* FROM Movies m JOIN Rental r ON m.MovieID = r.MovieID WHERE r.UserID = ?")) {
         pstmt.execute("USE visionvibe");
         pstmt.setInt(1, userId);
        
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            MovieClass movie = new MovieClass();
            int movieID = rs.getInt("MovieID");
            String language = rs.getString("OriginalLanguage");
            String title = rs.getString("Title");
            int popularity = rs.getInt("Popularity");
            double vote_average = (rs.getDouble("VoteAverage"));
            int vote_count = rs.getInt("VoteCount");
            double price = rs.getDouble("Price");
            System.out.printf("Movie ID: %d \n", movieID);
            System.out.printf("Language: %s \n", language);
            System.out.printf("Title: %s \n",title);
            System.out.printf("Popularity: %d \n", popularity);
            System.out.printf("Vote Average: %.1f \n", vote_average);
            System.out.printf("Vote Count: %d \n", vote_count);
            System.out.printf("Price: %.1f \n", price);
            System.out.println("--------------------------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
 
}
