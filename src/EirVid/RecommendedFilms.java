
package EirVid;
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wellington 2021330
 */

public class RecommendedFilms {
    public MovieClass[] getFilmsWatchedLast5Minutes() {
        ArrayList<MovieClass> watchedFilmsList = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement()) {

            stmt.execute("USE visionvibe");

            String query = "SELECT m.* FROM Movies m " +
               "JOIN Rental r ON m.MovieID = r.MovieID " +
               "WHERE r.Timestamp >= NOW() - INTERVAL 5 MINUTE " +    
               "LIMIT 5";
            
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    MovieClass film = new MovieClass();
                    film.setOriginal_language(rs.getString("OriginalLanguage"));
                    film.setTitle(rs.getString("Title"));
                    film.setPopularity(rs.getInt("Popularity"));
                    film.setVote_average(rs.getDouble("VoteAverage"));
                    film.setVote_count(rs.getInt("VoteCount"));
                    film.setPrice(rs.getDouble("Price"));

                    watchedFilmsList.add(film);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return watchedFilmsList.toArray(new MovieClass[0]);
    }
    
     public void display_recommendation(MovieClass[] films) {
        if (films != null) {
            System.out.println("Recommended Films:");
            for (MovieClass film : films) {
                System.out.println(film); // Assuming you have overridden toString() in the Film class
            }
        } else {
            System.out.println("No films watched in the last 5 minutes.");
        }
    }
}
