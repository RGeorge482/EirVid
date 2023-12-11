package EirVid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wellington 2021330
 */
public class UserRetrival {
    private DatabaseConnector connector;
    private String databaseName;

    public UserRetrival(DatabaseConnector connector, String databaseName) {
        this.connector = connector;
        this.databaseName = databaseName;
    }
    
    // Method to import to a list every user from DB
    public ArrayList<User> import_users(){
        //list to receive films once read from DB
        ArrayList<User> list_users = new ArrayList<>();

        try (Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement();
                ) {
            
            stmt.execute("USE " + databaseName);

            ResultSet rs = stmt.executeQuery("SELECT * from user");
            
            //setting all properties and adding it to the film list at the end
            while (rs.next()) {
                User user = new User();
                user.setUser_ID(rs.getInt("UserID"));
                user.setEmail(rs.getString("Email"));
                user.setUser_name(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                
                list_users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_users; //return it
    }
    
    
}
