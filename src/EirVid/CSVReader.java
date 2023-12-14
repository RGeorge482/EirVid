/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ignacioalarconvarela
 * 2021357
 */
public class CSVReader implements DataInput {
    BufferedReader myReader; 
    List<String> lines = new ArrayList<>();
    
    @Override
    
    public List<String> getData() throws IOException {
        myReader = new BufferedReader(new FileReader("movie.csv"));
        
        String inputLine = myReader.readLine();
        
        
        
        while ((inputLine = myReader.readLine()) != null) {
            System.out.println("Inputline: " + inputLine);
            lines.add(inputLine);
            
        }
        return lines;
    }
    
    
}
