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
public class RentalTableCreator {
    private DatabaseConnector connector;
    private String databaseName;
    
    public RentalTableCreator(String databaseName, DatabaseConnector connector){
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
}
