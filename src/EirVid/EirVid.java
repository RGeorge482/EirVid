/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EirVid;
import java.sql.Connection;
import java.util.Scanner;
import static EirVid.MenuClass.showMainMenu;
import static EirVid.MenuClass.showUserMenu;
import java.sql.SQLException;

/**
 *
 * @author bernardogandara
 */
public class EirVid {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        
        MenuOptions myOptions = new MenuOptions();   
        User myUser = new User(null, null, null);
        Controller myController = new Controller( myUser, myOptions);
        
//        THIS CAN BE LATER EXCLUDED, JUST ADDED THIS TO THE PROJECT AS I NEED FILM INFO 
//        IN ORDER TO CREATE A FOREIGNER KEY AND KEEP TRACK OF FILMS WATCHED BY USERS
//         YOU RAN FIRST TIME ERROR IS CAUSED AS IT IS SEARCHING FOR NON EXISITING DB
//        AFTER THAT THE SCHEMAS ARE CREATED BUT AS PK IS HARDCODED ERRROR OCCURS
        FilmsInsertion initializeFilm = new FilmsInsertion();
        initializeFilm.save_film_info(1, "Eng", "Test", 9, 5.0, 1, 2.50);
        initializeFilm.save_film_info(8, "Eng", "Test", 10,5.0, 2, 3.50);
        initializeFilm.save_film_info(3, "Eng", "Test", 8, 5.0, 3, 4.50);
        initializeFilm.save_film_info(4, "Eng", "Test", 7, 5.0, 4, 5.50);
        initializeFilm.save_film_info(5, "Eng", "Test", 6, 5.0, 5, 6.50);
        initializeFilm.save_film_info(6, "Eng", "Test", 5, 5.0, 6, 7.50);
        initializeFilm.save_film_info(7, "Eng", "Test", 7, 5.0, 7, 8.50);
        
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
        
        DatabaseInitializer initialize = new DatabaseInitializer();
        initialize.setupDatabase();

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
