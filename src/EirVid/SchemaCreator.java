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
public class SchemaCreator {
    private String databaseName;
    private DatabaseConnector connector;
    
    public SchemaCreator(String databaseName, DatabaseConnector connector){
        this.databaseName = databaseName;
        this.connector = connector;
    }
    
    public void createDatabase(){
        String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        try(Connection connect = connector.getConnection(); Statement stmt = connect.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Database " + databaseName + " created successfully.");
        }catch(SQLException e){
            System.out.println("An error occured while creating the database: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
