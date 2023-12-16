/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.util.Scanner;
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
        
        MovieDisplay film_display = new MovieDisplay();
        film_display.printAllFilms(); //PRINT ALL FILMS

        
        System.out.print("Select a movie: ");
        int movieChoice = mySc.nextInt();
        
        // Logic to handle movie selection based on 'movieChoice'
        System.out.print("Confirm? (Y/N): ");
        String confirmation = mySc.next();

    if (confirmation.equalsIgnoreCase("Y")) {
        System.out.print("Film rented: ");
        film_display.price_name_output(movieChoice);// DISPLAY RENTED FILM INFO
        rental_manager.save_rental_info(movieChoice, 1); //IN HERE I NEED TO KEEP TRACK OF THE USER LOGGED IN 
        
    } else {
        // Return to menu
        return;
    }
        
    }
}