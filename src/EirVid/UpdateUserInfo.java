/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EirVid;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Gheorghita Rata mda21563
 */
public class UpdateUserInfo {
      private DatabaseConnector connector;

    public UpdateUserInfo(DatabaseConnector connector) {
        this.connector = connector;
    }

    public String update_userinfo(String columnToBeChanged, String username, String email_address, String old_info, String new_info) {
        String sqlSelect = "SELECT username, email FROM visionvibe.user WHERE username = ? AND email = ?";
        String sqlUpdate = "UPDATE visionvibe.user SET " + columnToBeChanged + " = ? WHERE " + columnToBeChanged + " = ? AND email = ?";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
             PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {

            stmtSelect.setString(1, username);
            stmtSelect.setString(2, email_address);
            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                stmtUpdate.setString(1, new_info);
                stmtUpdate.setString(2, old_info);
                stmtUpdate.setString(3, email_address);

                int rowsAffected = stmtUpdate.executeUpdate();
                if (rowsAffected > 0) {
                    return "Updated successfully";
                } else {
                    return "No update performed";
                }
            }
            return "User not found";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
