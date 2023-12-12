/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EirVid;
import java.sql.Connection;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardogandara
 */
public class EirVid {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        DatabaseInitializer initialize = new DatabaseInitializer();
        initialize.setupDatabase();
        
        // Initialize the DatabaseConnector
        DatabaseConnector connector = new DatabaseConnector();    
//       
        RentalInfoRetriever rental_retriever = new RentalInfoRetriever(connector, "visionvibe");
//    
//        ArrayList<Integer> films_ID = rental_retriever.import_rental(5);
//        
//        //Displaying info from rental db
//        RentalDisplay rental_info = new RentalDisplay();
//        ArrayList<Film> films = rental_info.import_films_by_ID(films_ID);
//        
//        for(Film filmDisplay : films){
//            System.out.println(filmDisplay.toString());
//        }
        //whenever i want to call a method that in the class it has the connector as property, i have to do as below
        FilmsDisplay films_retriever = new FilmsDisplay(connector, "visionvibe");
        films_retriever.printAllFilms();
        // Part 1
        System.out.println("Start");
        DataInputFactory dataInputFactory = new DataInputFactory();
        DataIOMenu ioMenu = new DataIOMenu();
        DataIOTypes type = ioMenu.makeMenu("Where do you want to get the data from?");
        DataInput input = dataInputFactory.makeDataInput(type);
        List<String> lines = input.getData();

        // Part 3
        MovieParser movieParser = new MovieParser(lines);

        // Validates before parsing
        List<MovieClass> movies = movieParser.parseInputData();
        
        // Part 4
        // Part 5
        DataOutputFactory dataOutputFactory = new DataOutputFactory();

        // Pass the connector to the DataOutputFactory
        dataOutputFactory.setConnector(connector); // You need to create this method in DataOutputFactory

        type = ioMenu.makeMenu("Where do you want to save the data to?");
    
        DataOutput output = dataOutputFactory.makeDataOutput(type);
        output.saveData(movies);

        MenuOptions myOptions = new MenuOptions();   
        User myUser = new User(null, null, null);
        Controller myController = new Controller( myUser, myOptions);
       
        //Switch Menu for terminal
        Scanner scanner = new Scanner(System.in);
        
        MenuClass menu_classes = new MenuClass();
        
        boolean isLoggedIn = false;
            while (true) {
                if (!isLoggedIn) {
                    menu_classes.showMainMenu();
                } else {
                    menu_classes.showUserMenu();
                }
            }
            
    }
}
