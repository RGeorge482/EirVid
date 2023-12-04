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
public class MovieTableCreator {
    private DatabaseConnector connector;
    private String databaseName;
    
    //CONSTRUCTOR
    public MovieTableCreator(String databaseName, DatabaseConnector connector){
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
    public void createMoviesTable(){
        String sql = "CREATE TABLE IF NOT EXISTS " + databaseName + ".Movies (" +
                    "MovieID INT AUTO_INCREMENT PRIMARY KEY, " +
                     "OriginalLanguage VARCHAR(10), " +
                     "OriginalTitle VARCHAR(255) NOT NULL, " +
                     "Overview TEXT, " +
                     "Popularity DECIMAL(10, 2), " +
                     "ReleaseDate DATE, " +
                     "Runtime INT, " +
                     "Tagline VARCHAR(255), " +
                     "Title VARCHAR(255) NOT NULL, " +
                     "VoteAverage DECIMAL(3, 1), " +
                     "VoteCount INT, " +
                     "Price DECIMAL(10, 2) " +
                ")";
        
        try(Connection conn = connector.getConnection(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Movie table created successfully.");
        }catch(SQLException e){
            System.out.println("An error occured while creating the Movies table: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
