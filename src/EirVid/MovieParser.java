/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ignacioalarconvarela
 * 2021357
 */
public class MovieParser {
    
    private List<String> inputData;
    private ArrayList<MovieClass> parsedMovies = new ArrayList<>();
    

    public MovieParser(List<String> inputData) {
        this.inputData = inputData;
    }
    
    public ArrayList<MovieClass> parseInputData() {
        
        for (String line : inputData) {
            
            String[] fields = line.split(";");
            
            System.out.println(fields[0]);
      
            
            String original_language = fields[0];
            double popularity = Double.parseDouble(fields[1].replace(",", "."));
            String title = fields[2];
            double vote_average = Double.parseDouble(fields[3].replace(",", "."));
            int vote_count = Integer.parseInt(fields[4]); 
            double price = Double.parseDouble(fields[5].replace(",","."));

            
            MovieClass movie = new MovieClass(original_language,  popularity,  title,  vote_average,  vote_count, price);
            parsedMovies.add(movie);
        }
        return parsedMovies;
    
    }
}
