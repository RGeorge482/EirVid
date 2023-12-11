/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

import java.util.ArrayList;
/**
 *
 * @author Wellington 2021330
 */
public class UserDisplay {
    private String databaseName = "visionvibe";
    private DatabaseConnector connector = new DatabaseConnector();
    private UserRetrival userRetrival = new UserRetrival(connector, databaseName);
    
    //empty constructor to call it on main
    public UserDisplay(){
            
    }
    
    public void display_list_users(){
        ArrayList<User> users = userRetrival.import_users();
        
        for(User user : users){
            System.out.println(user.toString());
        }
    }
}
