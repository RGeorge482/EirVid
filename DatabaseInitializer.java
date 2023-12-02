/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visionvibe;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author bernardogandara
 */
public class DatabaseInitializer {
    private DatabaseConnector connector;
    private SchemaCreator schemaCreator;
    private UserTableCreator userTableCreator;
    private MovieTableCreator movieTableCreator;
    
    //CONSTRUCTOR
    public DatabaseInitializer(){
        //Initialize the DatabaseConnector
        this.connector = new DatabaseConnector();
        
        //Initialize the SchemaCreator with the database name and DatabaseConnector
        this.schemaCreator = new SchemaCreator("VisionVibe", connector);
        
        //Initialize the userTableCreator with the database name and databaseConnector
        this.userTableCreator = new UserTableCreator("VisionVibe", connector);
        
        //Initialize the movieTableCreator with the database name and databaseConnector
        this.movieTableCreator = new MovieTableCreator("VisionVibe", connector);
    }
    
    public void setupDatabase(){
        //Create the schema
        schemaCreator.createDatabase();
        
        //Create the user table
        userTableCreator.createUserTable();
        
        //Craete the movie table
        movieTableCreator.createMoviesTable();
        
        
    }
}
