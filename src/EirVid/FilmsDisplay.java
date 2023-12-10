/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.util.ArrayList;
/**
 *
 * @author Wellington 2021330
 */
public class FilmsDisplay {
    private String databaseName = "visionvibe";
    private DatabaseConnector connector = new DatabaseConnector();
    private FilmRetrival filmRetrival = new FilmRetrival(connector, databaseName);
    
    //empty constructor to call it on main
    public FilmsDisplay(){
            
    }
    
    public void display_list_films(){
        ArrayList<Film> films = filmRetrival.import_films();
        
        for(Film film : films){
            System.out.println(film.toString());
        }
    }
}
