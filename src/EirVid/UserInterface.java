/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.sql.SQLException;

/**
 *
 * @author Gheorghita Rata
 * mda21563
 */
public interface UserInterface {
    public boolean user_login(String name, String user_password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;

    public boolean register(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

   // public String update_userinfo(String columnToBeChanged, String user_name, String email_address, String old_info, String new_info) throws ClassNotFoundException, InstantiationException, IllegalAccessException; 
}
