/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

/**
 *
 * @author Gheorghita Rata
 * mda21563
 */
// this class presents options in the console for the user
public class MenuOptions {
    public void user_menu_options(){
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("   You are logged in");
        System.out.println("------------------------------------");
        System.out.println("[1] Rent a movie");
        System.out.println("[2] Check rented movies");
        System.out.println("[3] Top 5 most recommended movies");
        System.out.println("[4] Modify Your Profile");
        System.out.println("------------------------------------");
        System.out.println("");
    }

    public void user_status(){
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("\t\tUser");
        System.out.println("------------------------------------");
        System.out.println("[1] Register");
        System.out.println("[2] Log In");
        System.out.println("");
    }
    
        public void update_user_info(){
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("   What field you want to update?");
        System.out.println("------------------------------------");
        System.out.println("[1] Username");
        System.out.println("[2] Email");
        System.out.println("[3] Password");
        System.out.println("[4] Back to the Main Menu");
        System.out.println("------------------------------------");
        System.out.println("");
    }
}
