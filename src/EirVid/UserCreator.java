/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Gheorgita Rata mda21563
 */
public interface UserCreator {
    public void saveData(List<UserHandler> users) throws IOException;
}
