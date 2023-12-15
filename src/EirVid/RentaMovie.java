/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

//import static EirVid.MenuClass.scanner;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author ignacioalarconvarela
 */
public class RentaMovie {
    private DatabaseConnector connector;

    public RentaMovie() {
        this.connector = new DatabaseConnector();
    }  
    //FilmsDisplay film_display_connector = new FilmsDisplay(connector, "visionvibe");
     RentalManager rental_manager = new RentalManager();
   
  
    public void rentAMovie() throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        Scanner mySc = new Scanner(System.in);
        
        FilmsDisplay film_display = new FilmsDisplay("visionvibe", this.connector);
        film_display.printAllFilms();

        
        System.out.print("Select a movie: ");
        int movieChoice = mySc.nextInt();
        
    // Logic to handle movie selection based on 'movieChoice'

        System.out.print("You selected [Movie Name]. Confirm? (Y/N): ");
        String confirmation = mySc.next();

    if (confirmation.equalsIgnoreCase("Y")) {
        // Output movie details and cost
        // Example: System.out.println("[Movie Name] - Price: $xx.xx");
        //We have to find out how to ge this user id
       
// rental_manager.save_rental_info( 1, movieChoice, 1);
        
    } else {
        // Return to menu
        return;
    }
        
    }
}