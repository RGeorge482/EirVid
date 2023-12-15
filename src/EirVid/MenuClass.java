/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.util.Scanner;
//import  EirVid.RentaMovie.rentAMovie;

/**
 *
 * @author ignacioalarconvarela
 */
public class MenuClass {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isLoggedIn = false;    
    private RentaMovie rent_movie = new RentaMovie();
    private DatabaseConnector connector;
    private String databaseName;
    
    private RentalInfoRetriever rentalInfoRetrival = new RentalInfoRetriever(connector, databaseName);

    public void showUserMenu() throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        int choice = scanner.nextInt();

        switch (choice) {
         
            // MENU TO IMPLEMENT METHOD OF RENTING !
            
            case 1:
                // LIST OF MOVIES;
                rent_movie.rentAMovie();   
                
                // SELECT A MOVIE
                
                break; 
                    
            case 2: //
                
                // Print previous watch logic
                //rentalInfoRetrival.import_rental(choice); // as a parameter we will need the user id
               
                break;
            case 3:
                // Print recommendations logic
                
                break;
            case 4:
                isLoggedIn = false; // Log out
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
}
