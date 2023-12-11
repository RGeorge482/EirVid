/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author George
 */
public class Controller {
    private User user;
    private MenuOptions options;

    public Controller(User user, MenuOptions options) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.user = user;
        this.options = options;

        Scanner mySc = new Scanner(System.in);

        ArrayList<UserInterface> users = new ArrayList<>(); // CREATING A NEW ARRAY LIST TO RECEIVE REGISTERED USERS

        Utilities myUt = new Utilities();

        boolean valid = false;
        String programHault = "";
        int userMenuChoice = -1, userSignLogin;

        do {
            options.user_status();//USER login or register
            System.out.println("");
                    options.user_status();
                    userSignLogin = myUt.Get_user_int("Please type one of the options above: ", 1, 2);
                    System.out.println("");
                    switch (userSignLogin) {
                        case 1://USER SELECTS REGISTER
                            String emailAddress="";
                            valid = false;
                            String username = myUt.get_user_input("Please, type your username: ");
                            System.out.println("");

                            do{
                                System.out.println("Please, type your email address");
                                emailAddress = mySc.next();
                                if(myUt.email_validator(emailAddress)) valid = true;
                                else System.out.println("Try an email containing '@' and a domain such as 'gmail.com'");
                                System.out.println("");
                            }while(!valid);//loop breaks if user email address is valid

                            System.out.println("");
                            System.out.print("Please type a password: ");
                            String userPassword = mySc.next();
                            
                            // Check User class constructor

                            // user = new User(username, emailAddress, userPassword);

                            // users.add(user); // Check here UserRetrival class  User user = new User();

                            user.register(user);//user registered

                            System.out.println("User registered successfully!");
                            break;

                        case 2://USER SELECTS LOGIN
                            String user_name_login = myUt.get_user_input("Please type your username: ");
                            System.out.print("Please, type your password: ");
                            String user_password_login = mySc.nextLine();

                            // this step only after userExists now here only for testing
                            options.user_menu_options();

                            boolean userExists = (user.user_login(user_name_login, user_password_login)); //method returns true if user exists and pass is correct

                            if (userExists) {
                                //if user exists maybe is a good idea to return an array list with all the info from this specific user
                                options.user_menu_options();
                                int loggedUserChoice = myUt.Get_user_int("Please type one of the options above: ", 1, 4);
                                System.out.println("");
                                // switch with options to rent, check rented movies, top 5 most recmmended movies, modify profile

                                break;
                            } else {
                                System.out.println("Your details seems to be incorrect, please try again!");
                            }
                            break;
                    }
            System.out.println("");
            programHault = myUt.get_user_valid_input("Would you like to return to the main menu? [y] or [n]");
        } while (programHault.equals("y"));//LOOP FOR THE USER TO RETURN TO MAIN HEADER
    }
}
