/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gheorghita Rata mda21563
 */
// class responsible to register a user
public class RegisterHandler{
    
    private final DatabaseConnector connector; // connection with the database
    private final String databaseName;

    public RegisterHandler(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
      // method responsible for sending username, email and password to the database
    public boolean register(User user) {
        String sql = "INSERT INTO VisionVibe.User(username, email, password) VALUES (?, ?, ?);";
        try (Connection conn = connector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);


            stmt.setString(1, user.getUser_name());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            System.out.println("Data stored successfully");


            stmt.close(); // Close the statement
            return true;
        } catch (SQLException e) {
            System.out.println("Problem registering user");
            e.printStackTrace();
            return false;
        }

    }
    
}
