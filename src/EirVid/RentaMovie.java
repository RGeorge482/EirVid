/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import static EirVid.MenuClass.scanner;

/**
 *
 * @author ignacioalarconvarela
 */
public class RentaMovie {
     public static void rentAMovie(){
         // Show list of movies
    // Example: System.out.println("1. Movie A\n2. Movie B\n...");

    System.out.print("Select a movie: ");
    int movieChoice = scanner.nextInt();
    // Logic to handle movie selection based on 'movieChoice'

    System.out.print("You selected [Movie Name]. Confirm? (Y/N): ");
    String confirmation = scanner.next();

    if (confirmation.equalsIgnoreCase("Y")) {
        // Output movie details and cost
        // Example: System.out.println("[Movie Name] - Price: $xx.xx");
    } else {
        // Return to menu
        return;
    }
        
    }
}
