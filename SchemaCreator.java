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
public class SchemaCreator {
    private String databaseName;
    private DatabaseConnector connector;
    
    public SchemaCreator(String databaseName, DatabaseConnector connector){
        this.databaseName = databaseName;
        this.connector = connector;
    }
    
    public void createDatabase(){
        String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        
    }
    
}
