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
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;
/**
 *
 * @author Wellington 2021330
 */

public class RentalManager {
    public RentalManager() {
    }
       
    //Sending data to DB rental
    public boolean save_rental_info(int movie_ID, int user_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();//Creating the queries `statements`
            stmt.execute("USE visionvibe;");
            stmt.execute(
                    String.format("INSERT INTO rental (MovieID, UserID) "
                            + "VALUES (%d, %d);",
                            movie_ID, user_ID)
            );
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
