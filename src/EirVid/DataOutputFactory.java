/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EirVid;

/**
 *
 * @author ignacioalarconvarela
 * 2021357
 */
public class DataOutputFactory {
    
    private DatabaseConnector connector;
    private String databaseName;
    
    public void setConnector(DatabaseConnector connector) {
    this.connector = connector;
}
    
     public DataOutput makeDataOutput(DataIOTypes type) {
       
      
         switch (type) {
            case DATABASE : return new DataBaseOutput(databaseName, connector);
            default : return null;
        }
    }
    
    
}
