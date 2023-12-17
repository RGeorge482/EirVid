/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Gheorghita Rata
 * mda21563
 */
// this class is responsible for all the logic of the application
public class Controller {
    private User user;
    private MenuOptions options;
    private DatabaseConnector connector;
    private Utilities myUt;
    private RentalManager rental_manager;
    private MovieDisplay film_display;
    protected RentalDisplay my_rentals;
    protected RecommendedFilms recommended_films;
    
    // constructor implemented
public Controller() throws SQLException {
    this.options = new MenuOptions();
    this.connector = new DatabaseConnector();
    this.myUt = new Utilities();
    this.film_display = new MovieDisplay(); 
    this.my_rentals = new RentalDisplay();
    this.rental_manager = new RentalManager();
    this.recommended_films = new RecommendedFilms();
}

    // method to start the application
    public void start() throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        Scanner mySc = new Scanner(System.in);
        boolean valid;
        int userSignLogin; // variable used to store the user input
        String programHault; // variable used to store the user input

        do {
            options.user_status(); // User login or register
            userSignLogin = myUt.Get_user_int("Please type one of the options above: ", 1, 2);

            switch (userSignLogin) {
                case 1: // this is the case when user register
                    handleRegistration(mySc);
                    break;

                case 2: // this is the case when user login
                    handleLogin(mySc);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            programHault = myUt.get_user_valid_input("Would you like to return to the main menu? [y] or [n]");
        } while (programHault.equalsIgnoreCase("y"));
    }

    // method responsible with registration
    private void handleRegistration(Scanner mySc) {
        String username = myUt.get_user_input("Please, type your username: ");
        String emailAddress = getUserEmail(mySc);
        String userPassword = getUserPassword(mySc);

        User newUser = new User(username, emailAddress, userPassword); // here I am creating a new user object
        RegisterHandler registerHandler = new RegisterHandler(connector, "visionvibe"); // using the DatabaseConnector class I am registering a new user object
        //y3cagroup
        if (registerHandler.register(newUser)) { // user is registered successfully
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed.");
        }
    }

    // method responsible for login
    private void handleLogin(Scanner mySc) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String user_name_login = myUt.get_user_input("Please type your username: ");
        String user_password_login = getPasswordFromUser(mySc, "Please, type your password: ");

        LoginHandler loginHandler = new LoginHandler(connector, "visionvibe"); // using the DatabaseConnector class and in LoginHandler

        if (loginHandler.user_login(user_name_login, user_password_login)) { // user is login successfully
            handleLoggedInUser(mySc);
        } else {
            System.out.println("Your details seem to be incorrect, please try again!");
        }
    }
    
    //takes user name and pass it on if statement
    //if user does not exist returns message
    
    private void filmRentalAuthorisation() throws IllegalAccessException, InstantiationException, ClassNotFoundException {              
        String user_name_login = myUt.get_user_input("Please type your username: ");

        LoginHandler loginHandler = new LoginHandler(connector, "visionvibe"); // using the DatabaseConnector class and in LoginHandler
        
        if (loginHandler.user_name(user_name_login)) { //make sure user exists
            int userId = loginHandler.user_id(user_name_login);//is so userId receiver this user id 
            
            film_display.printAllFilms();
         
            System.out.print("Select a movie: ");
                
            int movieChoice = myUt.Get_user_int("Please select one film: ", 1, 1000000);
                
            System.out.print("Film rented: ");
            film_display.price_name_output(movieChoice);
            System.out.println("");
            rental_manager.save_rental_info(movieChoice, userId); //IN HERE I NEED TO KEEP TRACK OF THE USER LOGGED IN 
        
        } else {
            System.out.println("Your details seem to be incorrect, please try again!");
        }
    }

    // this method handles the options for rent a movie, checking rented movie, top 5 recommended movie, and user update option
    private void handleLoggedInUser(Scanner mySc) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        LoginHandler loginHandler = new LoginHandler(connector, "visionvibe");
        options.user_menu_options();
        int loggedUserChoice = myUt.Get_user_int("Please type one of the options above: ", 1, 4);

        switch (loggedUserChoice) {
            case 1:
                filmRentalAuthorisation();
                break;
            case 2:
                String userName = myUt.get_user_input("Type your name: ");
                
                if (loginHandler.user_name(userName)){
                    System.out.println("Movies History");
                    System.out.println("--------------------------");
                    my_rentals.get_movies_by_userID(loginHandler.user_id(userName));
                    System.out.println("");
                }else{
                    System.out.println("User not identified");
                }
                break;
            case 3:
                MovieClass[] array_films = recommended_films.getFilmsWatchedLast5Minutes();
                recommended_films.display_recommendation(array_films);
                System.out.println("");
                break;
            case 4:
                // change info
                handleUserUpdate(mySc);
                break;
            default:
                System.out.println("Option not available. Try again.");
                System.out.println("");
                break;
        }
    }

    // in this method is implemented the logic for updating username, email or password
    private void handleUserUpdate(Scanner mySc) {
        // Logic to handle user updates
        options.update_user_info();
        int loggedUserChoice = myUt.Get_user_int("Please type one of the options above: ", 1, 4);

        switch (loggedUserChoice) {
            case 1:
                // Update Username
                updateUsername(mySc);
                break;
            case 2:
                // Update Email
                updateEmail(mySc);
                break;
            case 3:
                // Update Password
                updatePassword(mySc);
                break;
            case 4:
                // Back to the Main Menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    private void updateUsername(Scanner mySc) {
        // I implement logic to update username
        System.out.print("Please enter your current username: ");
        String currentUsername = mySc.nextLine();

        System.out.print("Please enter your new username: ");
        String newUsername = mySc.nextLine();

        // I create an instance of DatabaseConnector
        DatabaseConnector connector = new DatabaseConnector();

        // I create an instance of UpdateUserInfo and pass the DatabaseConnector to it
        UpdateUserInfo userInfoUpdater = new UpdateUserInfo(connector);

        System.out.print("Please enter your email address: ");
        String userEmail = mySc.nextLine();

        // Here the username is updated in the database
        String result = userInfoUpdater.update_userinfo("username", currentUsername, userEmail, currentUsername, newUsername);
        System.out.println(result);
    }

    // Method responsible for update email
    private void updateEmail(Scanner mySc) {
        // update email
        System.out.print("Please enter your username: ");
        String username = mySc.nextLine();

        System.out.print("Please enter your current email address: ");
        String currentEmail = mySc.nextLine();

        // ask user for the new email address
        System.out.print("Please enter your new email address: ");
        String newEmail = mySc.nextLine();

        DatabaseConnector connector = new DatabaseConnector();

        UpdateUserInfo userInfoUpdater = new UpdateUserInfo(connector);

        // email is updated in the database
        String result = userInfoUpdater.update_userinfo("email", username, currentEmail, currentEmail, newEmail);
        System.out.println(result);
    }

    // update password method, user to be able to update the password needs to provide the username, email and current password
    private void updatePassword(Scanner mySc) {
        System.out.print("Please enter your username: ");
        String username = mySc.nextLine();

        System.out.print("Please enter your email address: ");
        String email = mySc.nextLine();

        System.out.print("Please enter your current password: ");
        String currentPassword = mySc.nextLine();

        System.out.print("Please enter your new password: ");
        String newPassword = mySc.nextLine();

        DatabaseConnector connector = new DatabaseConnector();

        UpdateUserInfo userInfoUpdater = new UpdateUserInfo(connector);

        // password is updated in the database
        String result = userInfoUpdater.update_userinfo("password", username, email, currentPassword, newPassword);
        System.out.println(result);
    }

    // email validation
    private String getUserEmail(Scanner mySc) {
        String emailAddress;
        do {
            System.out.println("Please, type your email address");
            emailAddress = mySc.next();
            if (myUt.email_validator(emailAddress)) {
                break;
            } else {
                System.out.println("Invalid email. Please try again.");
            }
        } while (true);
        return emailAddress;
    }

    // ask for user password
    private String getUserPassword(Scanner mySc) {
        System.out.print("Please type a password: ");
        return mySc.next();
    }

    private String getPasswordFromUser(Scanner mySc, String prompt) {
        System.out.print(prompt);
        return mySc.nextLine();
    }
}
