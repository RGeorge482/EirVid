/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static EirVid.DatabaseConnector.URL;
import static EirVid.DatabaseConnector.USER;
import static EirVid.DatabaseConnector.PASSWORD;
/**
 *
 * @author Wellington 2021330
 */

public class RentalInfoRetriever {
    public RentalInfoRetriever() {
    }
    
    public ArrayList<Integer> import_rental(int userID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{//takes user id as par 
        //Will hold the films from the specified ID
        ArrayList<Integer> film_list_by_ID = new ArrayList<>();
        
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        try { 
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE visionvibe");
            ResultSet rs = stmt.executeQuery("SELECT MovieID FROM rental WHERE UserID = " + userID);//Returns only those which matches ID in parameter
            //Adding film if exists to array list
            while (rs.next()) {
                int movieID = rs.getInt("MovieID"); //receiving movie id from db according to userID
                film_list_by_ID.add(movieID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return film_list_by_ID;//returs list of integers that represents movies id
    }
}

//LATER IF WE WANT TO EXTRACT ALL FILMS FROM DB IN ORDER TO RECOMMEND SOME, I CAN JUST CREATE A LIST FOR ALL FILMS FROM DB