/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wellington 2021330
 */

public class RentalManager {
    private DatabaseConnector connector;
    private String databaseName;
    String DB_URL = "jdbc:mysql://localhost/";
    String USER = "root";
    String PASSWORD = "root";
    
     public RentalManager(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }

    public RentalManager() {
    }
       
     //Sending data to DB rental
    public boolean save_rental_info(int rental_ID, int movie_ID, int user_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();//Creating the queries `statements`
            stmt.execute("USE visionvibe;");
            stmt.execute(
                    String.format("INSERT INTO rental (RentalID, MovieID, UserID) "
                            + "VALUES (%d, %d, %d);",
                            rental_ID, movie_ID, user_ID)
            );
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
