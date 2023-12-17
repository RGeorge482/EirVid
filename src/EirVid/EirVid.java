/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EirVid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bernardogandara
 */

// github repository link 
// https://github.com/RGeorge482/EirVid


public class EirVid {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        DatabaseInitializer initialize = new DatabaseInitializer();
        initialize.setupDatabase();
        
        // Initialize the DatabaseConnector
        DatabaseConnector connector = new DatabaseConnector();    

        // Part 1
        System.out.println("Start");
        DataInputFactory dataInputFactory = new DataInputFactory();
        DataIOMenu ioMenu = new DataIOMenu();
        DataIOTypes type = ioMenu.makeMenu("Where do you want to get the data from?");
        DataInput input = dataInputFactory.makeDataInput(type);
        List<String> lines = input.getData();

        // Part 3
        MovieParser movieParser = new MovieParser(lines);

        List<MovieClass> movies = movieParser.parseInputData();
        
        // Part 5
        DataOutputFactory dataOutputFactory = new DataOutputFactory();

        // Pass the connector to the DataOutputFactory
        dataOutputFactory.setConnector(connector); 
        
        type = ioMenu.makeMenu("Where do you want to save the data to?");
        DataOutput output = dataOutputFactory.makeDataOutput(type);
        output.saveData(movies);

        
        //Part 6 application logic
        // Controller is instantiated
        Controller myController = new Controller();
        myController.start();
        
        MenuOptions myOptions = new MenuOptions();  
        
        User myUser = new User(null, null, null);
 
       
    }
}
