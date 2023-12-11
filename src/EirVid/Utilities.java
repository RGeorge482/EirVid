/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author George
 */
public class Utilities {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private static Pattern pattern;
    private static Matcher matcher;

    public Utilities(){
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public boolean email_validator(String email_address) {
        matcher = pattern.matcher(email_address);
        return matcher.matches();
    }


    public String get_user_valid_input(String prompt) {
        Scanner myScanner = new Scanner(System.in);

        String input = "", inputToLowerCase;
        do {

            System.out.println(prompt);
            System.out.println("Only type y or n, please: ");
            input = myScanner.nextLine();
            inputToLowerCase = input.toLowerCase();

        } while ((!inputToLowerCase.equals("y")) && (!inputToLowerCase.equals("n")));
        return input;
    }

    public String get_user_input(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println(prompt + " ");
            System.out.print("Please only type letters: ");
            input = myScanner.nextLine();
            System.out.println("");
        } while (!input.matches("[a-zA-Z ]+"));

        return input;
    }

    public int Get_user_int(String prompt, int minValue, int maxValue) {
        Scanner myScanner = new Scanner(System.in);
        int input = -1;
        boolean valid = false;
        do {
            System.out.print(prompt);
            try {
                input = myScanner.nextInt();
                if (input < minValue || input > maxValue) {
                    System.out.println("The number entered does not match requirements. Please, try again:");
                } else {

                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("The value entered is not an integer. Please type only 1 or 2");
                myScanner.next();
            }
        } while (!valid);
        System.out.println("");
        return (input);
    }   
}
