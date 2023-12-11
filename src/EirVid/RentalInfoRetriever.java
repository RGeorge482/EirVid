/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wellington 2021330
 */
public class RentalInfoRetriever {
    private DatabaseConnector connector;
    private String databaseName;

    public RentalInfoRetriever(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }

    public RentalInfoRetriever() {
    }
    
    // Method to import to a list every film
    public Map<Integer, ArrayList<Film>> import_rental(){
        //list to receive films rented by all users
        FilmRetrival film_retrival = new FilmRetrival(connector, databaseName);
        //Filling list with films coming from db
        ArrayList<Film> film_list = film_retrival.import_films();
        
        Map<Integer, ArrayList<Film>> user_film_map = new HashMap<>();
        
        try (Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE " + databaseName);

            ResultSet rs = stmt.executeQuery("SELECT UserID, MovieID from rental");
            
            //setting all properties and adding it to the film list at the end
            while (rs.next()) {
                int userID = rs.getInt("UserID");
                int movieID = rs.getInt("MovieID");
                
                Film film = find_film_by_ID(film_list, movieID);
                
                user_film_map.computeIfAbsent(userID, k -> new ArrayList<>()).add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_film_map; //return it
    }
    
    //THIS FUNCTION WILL LATER BE MOVED
    public static Film find_film_by_ID(List<Film> films, int movie_ID){
        for(Film film : films){
            if(film.getMovie_id() == movie_ID) return film;
        }
        return null;
    }
}
