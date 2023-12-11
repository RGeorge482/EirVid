/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ignacioalarconvarela
 * 2021357
 */
public class DataBaseOutput implements DataOutput {
    
    private final DatabaseConnector connector;
    private final String databaseName;
    
    public DataBaseOutput(String databaseName, DatabaseConnector connector){
        this.connector = connector;
        this.databaseName = databaseName;
    }

    @Override
    public void saveData(List<MovieClass> movies) throws IOException {
    String sql = "INSERT INTO VisionVibe.Movies (OriginalLanguage, Title, Popularity, VoteAverage, VoteCount, Price) VALUES (?, ?, ?, ?, ?, ?);";

    try (Connection conn = connector.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement(sql);

        for (MovieClass movie : movies) {
            stmt.setString(1, movie.getOriginalLanguage());
            stmt.setString(2, movie.getTitle());
            stmt.setDouble(3, movie.getPopularity());
            stmt.setDouble(4, movie.getVoteAverage());
            stmt.setInt(5, movie.getVoteCount());
            stmt.setDouble(6, movie.getPrice());

            stmt.executeUpdate();
            System.out.println("Data stored successfully");
        }

        stmt.close(); // Close the statement
    } catch (SQLException e) {
        System.out.println("Problem with saving Movies");
        e.printStackTrace();
    }
}}

    


