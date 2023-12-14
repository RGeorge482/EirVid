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

  public  void showMainMenu() throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        System.out.println("1. Create Account\n2. Login\n3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                // Create account logic
                break;
            case 2:
                // Login logic
                showUserMenu();
                isLoggedIn = true; // Set to true on successful login
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void showUserMenu() throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        System.out.println("1. Rent a Movie\n2. Print Previous Watch\n3. Print Recommendations\n4. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Rent a movie logic rentAMovie();
                rent_movie.rentAMovie();
                
                break;
           
                    
            case 2:
                // Print previous watch logic
                rentalInfoRetrival.import_rental(choice); // as a parameter we will need the user id
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
