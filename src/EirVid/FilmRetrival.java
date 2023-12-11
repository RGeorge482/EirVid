package EirVid;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wellington 2021330 -> Class used to display films
 * This class is currently displaying films that were inserted manually as a test
 */
public class FilmRetrival {
    private final DatabaseConnector connector;
    private final String databaseName;

    public FilmRetrival(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
    // Method to import to a list every film
    public ArrayList<Film> import_films(){
        //list to receive films once read from DB
        ArrayList<Film> list_films = new ArrayList<>();

        try (Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE " + databaseName);

            ResultSet rs = stmt.executeQuery("SELECT * from movies");
            
            //setting all properties and adding it to the film list at the end
            while (rs.next()) {
                Film film = new Film();
                film.setMovie_id(rs.getInt("MovieID"));
                film.setOriginal_language(rs.getString("OriginalLanguage"));
                film.setTitle(rs.getString("Title"));
                film.setPopularity(rs.getInt("Popularity"));
                film.setVote_average(rs.getDouble("VoteAverage"));
                film.setCount(rs.getDouble("VoteCount"));
                film.setPrice(rs.getDouble("Price"));
                
                list_films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_films; //return it
    }
}
