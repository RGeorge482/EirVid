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
 * @author Wellington
 * This class can be later deleted it is just to test
 */
public class UsersManager {
   // String dbName = "movies";
    String DB_URL = "jdbc:mysql://localhost/";
    String USER = "root";
    String PASSWORD = "root";
    
       public boolean save_user_info(int user_ID, String username, String email, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();//Creating the queries `statements`
            stmt.execute("USE visionvibe;");
            stmt.execute(
                    String.format("INSERT INTO user (UserID, Username, Email, Password) "
                            + "VALUES (%d, \"%s\", \"%s\", \"%s\");",
                            user_ID, username, email, password)
            );
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
