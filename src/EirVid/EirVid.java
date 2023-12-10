/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EirVid;
import java.sql.Connection;
import java.util.Scanner;
import static EirVid.menuClass.showMainMenu;
import static EirVid.menuClass.showUserMenu;
/**
 *
 * @author bernardogandara
 */
public class EirVid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
