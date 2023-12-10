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
public class UserTableCreator {
    private DatabaseConnector connector;
    private String databaseName;
    
    
    //CONSTRUCTOR
    public UserTableCreator(String databaseName, DatabaseConnector connector){
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
    public void createUserTable(){
        String sql = "CREATE TABLE IF NOT EXISTS " + databaseName + ".User (" +
                "UserID INT AUTO_INCREMENT PRIMARY KEY, " +
                "Username VARCHAR(255) NOT NULL, " + 
                "Email VARCHAR(255) NOT NULL, " +
                "Password VARCHAR(255) NOT NULL" +
                ")";
        try(Connection conn = connector.getConnection(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("User table created successfully.");
        }catch(SQLException e){
            System.out.println("An error occured while creating the User table: " + e.getMessage());
            e.printStackTrace();
        }
    }   
}