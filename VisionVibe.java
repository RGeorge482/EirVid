/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package visionvibe;

/**
 *
 * @author bernardogandara
 */
public class VisionVibe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseInitializer initialize = new DatabaseInitializer();
        initialize.setupDatabase();
    }
    
}
