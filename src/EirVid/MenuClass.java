/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.sql.SQLException;
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
    RentalDisplay my_rentals = new RentalDisplay();
    RecommendedFilms recommended_films = new RecommendedFilms();
    
    public void showUserMenu() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException{
        int choice = scanner.nextInt();

        switch (choice) {
            
            case 1:
                rent_movie.rentAMovie();   
                break; 
                    
            case 2: //
                System.out.println("Movies History");
                System.out.println("--------------------------");
                my_rentals.get_movies_by_userID(1);
                break;
            case 3:
                MovieClass[] array_films = recommended_films.getFilmsWatchedLast5Minutes();
                recommended_films.display_recommendation(array_films);
                break;
            case 4:
                isLoggedIn = false; // Log out
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
}
