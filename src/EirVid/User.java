/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;

/**
 *
 * @author Wellington -> 2021330
 */
public class User {
    private String user_name; 
    private String email;
    private String password; 
    private int user_ID;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    @Override
    public String toString() {
        return "User{" + "user_name=" + user_name + ", email=" + email + ", password=" + password + ", user_ID=" + user_ID + '}';
    }
}
