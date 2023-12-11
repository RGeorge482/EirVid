/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bernardogandara 2021283
 */
public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/"; //MySQL URL and port
    private static final String USER = "root"; //MySQL username
    private static final String PASSWORD = "root"; //MySQL password
    
    //CONNECT TO THE DATABASE method()
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
}
