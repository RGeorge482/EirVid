/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EirVid;
import java.sql.Connection;
import java.util.Scanner;
import static EirVid.MenuClass.showMainMenu;
import static EirVid.MenuClass.showUserMenu;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bernardogandara
 */
public class EirVid {

<<<<<<< HEAD
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       
        // George 
=======
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

        
        
        
>>>>>>> da09d9f14a255e7f595acb12514ec482666883b5
        MenuOptions myOptions = new MenuOptions();   
        User myUser = new User(null, null, null);
        Controller myController = new Controller( myUser, myOptions);
        
<<<<<<< HEAD
////        THIS CAN BE LATER EXCLUDED, JUST ADDED THIS TO THE PROJECT AS I NEED FILM INFO 
////        IN ORDER TO CREATE A FOREIGNER KEY AND KEEP TRACK OF FILMS WATCHED BY USERS
////         YOU RAN FIRST TIME ERROR IS CAUSED AS IT IS SEARCHING FOR NON EXISITING DB
////        AFTER THAT THE SCHEMAS ARE CREATED BUT AS PK IS HARDCODED ERRROR OCCURS
        FilmsInsertion initializeFilm = new FilmsInsertion();
        initializeFilm.save_film_info(1, "Eng", "Test", 9, 5.0, 1, 2.50);
        initializeFilm.save_film_info(8, "Eng", "Test", 10,5.0, 2, 3.50);
        initializeFilm.save_film_info(3, "Eng", "Test", 8, 5.0, 3, 4.50);
        initializeFilm.save_film_info(4, "Eng", "Test", 7, 5.0, 4, 5.50);
        initializeFilm.save_film_info(5, "Eng", "Test", 6, 5.0, 5, 6.50);
        initializeFilm.save_film_info(6, "Eng", "Test", 5, 5.0, 6, 7.50);
        initializeFilm.save_film_info(7, "Eng", "Test", 7, 5.0, 7, 8.50);
=======
>>>>>>> da09d9f14a255e7f595acb12514ec482666883b5
        
        UsersManager insertUser = new UsersManager();
        insertUser.save_user_info(2, "Bernardo", "rol", "no matter it is all the same");
        insertUser.save_user_info(3, "Ignacio", "dan", "no matter it is all the same");
        insertUser.save_user_info(4, "Rata", "ga", "no matter it is all the same");
        insertUser.save_user_info(5, "Wellington", "wow", "no matter it is all the same");
        
        //Method to display all films that has been extracted from db and are in a list
        FilmsDisplay films_display = new FilmsDisplay();
        films_display.display_list_films();
       
        //Method to display all users that has been extracted from db and are in a list
        UserDisplay user_display = new UserDisplay();
        user_display.display_list_users();
        
        RentalManager rental_display = new RentalManager();
        rental_display.save_rental_info(1, 1, 5);
        rental_display.save_rental_info(2, 3, 5);
        rental_display.save_rental_info(3, 4, 5);
        rental_display.save_rental_info(4, 7, 5);
        
        

           // Switch Menu for terminal
        Scanner scanner = new Scanner(System.in);
    
        boolean isLoggedIn = false;
            while (true) {
                if (!isLoggedIn) {
                    showMainMenu();
                } else {
                    showUserMenu();
                }
            }
            
    }
}
