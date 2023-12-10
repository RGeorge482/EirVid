/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bernardogandara 2021283
 */
public class RentalTableCreator {
    private DatabaseConnector connector;
    private String databaseName;
    
    public RentalTableCreator(String databaseName, DatabaseConnector connector){
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
    public void createRentalTable(){
        String sql = "CREATE TABLE IF NOT EXISTS " + databaseName + ".Rental (" +
                "RentalID INT AUTO_INCREMENT PRIMARY KEY, " +
                "MovieID INT, " +
                "UserID INT, " +
                "Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "FOREIGN KEY (MovieID) REFERENCES Movies(MovieID), " +
                "FOREIGN KEY (UserID) REFERENCES User(UserID)" +
                ")";
        
        try(Connection conn = connector.getConnection(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Rental table created successfully.");
        }catch(SQLException e){
            System.out.println("An error occured while creating the Rental table: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
