/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;

/**
 *
 * @author Wellington
 */
public class MovieInsertion {
    
       public boolean save_film_info(int movie_id, String original_language, String original_title, int popularity, double vote_average, int vote_count, double price) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();//Creating the queries `statements`
            stmt.execute("USE visionvibe;");
            stmt.execute(
                    String.format("INSERT INTO movies (MovieID, OriginalLanguage, Title, Popularity, VoteAverage, VoteCount, Price) "
                            + "VALUES (%d, \"%s\", \"%s\", %d, %f, %d, %f);",
                            movie_id, original_language, original_title, popularity, vote_average, vote_count, price)
            );
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
