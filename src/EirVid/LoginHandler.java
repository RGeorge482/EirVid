/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gheorghita Rata mda21563
 */
// class responsible for user login
public class LoginHandler {
    private final DatabaseConnector connector; // connection with the database
    private final String databaseName;
    
    public LoginHandler(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
       // method that takes username and password and send it to the database, returns true if login successful
    public boolean user_login(String username, String password) {
        String sql = "SELECT username, password FROM visionvibe.user WHERE username = ?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("password").equals(password)) {
                System.out.println("User Login Successful");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } 
    //return just the name in order to make sure user exists before renting film
     public boolean user_name(String username) {
        String sql = "SELECT username FROM visionvibe.user WHERE username = ?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("UserName").equals(username)) {
                System.out.println("User Login Successful");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } 
     
    //Method used to guarantee user is inserted into DB and retrieve true if user exists
    //This method is called to keep track userID
        public int user_id(String username) {
        String sql = "SELECT UserID, Username FROM visionvibe.user WHERE username = ?";
        try (Connection conn = connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("Username").equals(username)) {
                System.out.println("Operation Successful");
                return rs.getInt("UserID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    } 
}
