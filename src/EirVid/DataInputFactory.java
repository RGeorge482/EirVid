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
public class DataInputFactory {
    public DataInput makeDataInput(DataIOTypes inputType) {
        switch (inputType) {
            case CSV : return new CSVReader();
            default: return null;
        }
    }
}