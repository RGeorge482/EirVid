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
                     "Title VARCHAR(255) NOT NULL, " +
                     "Popularity DECIMAL(10, 2), " +
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
