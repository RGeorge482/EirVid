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
}
