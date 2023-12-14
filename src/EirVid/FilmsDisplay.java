package EirVid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FilmsDisplay {
    private DatabaseConnector connector;
    private String databaseName;

    public FilmsDisplay(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }

    public FilmsDisplay() {
    }
    
    
    public void printAllFilms() {
        try (Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE " + databaseName);
            
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
}