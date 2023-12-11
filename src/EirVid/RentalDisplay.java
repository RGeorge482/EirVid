/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.util.ArrayList;
import java.util.Map;

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
    //par is the map
    public void display_list_rental(){
        Map<Integer, ArrayList<Film>> user_film_map = rentalInfoRetrival.import_rental();
        
        for(Map.Entry<Integer, ArrayList<Film>> entry : user_film_map.entrySet()) {
            int user_id = entry.getKey();
            ArrayList<Film> films_watched = entry.getValue();
            
            System.out.println("User ID: " + user_id + ", Films watched:");
            for(Film film : films_watched) {
                System.out.println("\t" + film);
            }
        }
    }
}
