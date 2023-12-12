/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wellington 2021330
 */
public class RentalDisplay {
    private String databaseName = "visionvibe";
    private DatabaseConnector connector = new DatabaseConnector();
    private RentalInfoRetriever rentalInfoRetrival = new RentalInfoRetriever(connector, databaseName);
    //empty constructor to call it on main
    public RentalDisplay(){
            
    }
    
    // Method to import to a list every film
    public ArrayList<Film> import_films_by_ID(ArrayList<Integer> movie_IDs) throws SQLException{
        //list to receive films once read from DB
        ArrayList<Film> list_films_by_ID = new ArrayList<>();

        try (Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE " + databaseName);

            StringBuilder querySelector = new StringBuilder("SELECT * FROM movies WHERE MovieID IN (");
            for (int i = 0; i < movie_IDs.size(); i++) {
               querySelector.append("?");
               if(i < movie_IDs.size() - 1) {
                   querySelector.append(", ");
               }
            }
            querySelector.append(")");
            
        try (PreparedStatement pstmt = conn.prepareStatement(querySelector.toString())) { 
            for (int i = 0; i < movie_IDs.size(); i++) {
                pstmt.setInt(i + 1, movie_IDs.get(i));
            }
            
            ResultSet rs = pstmt.executeQuery();
            
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
                
                list_films_by_ID.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_films_by_ID; //return it
        }
    }
}
