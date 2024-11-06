/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.util;

import java.sql.SQLException;
import java.time.LocalDateTime;
import parkmaster.dao.SystemLogDAO;

/**
 *
 * @author rolas
 */
public class SystemLogs {
    private final SystemLogDAO logDAO;

    public SystemLogs() throws SQLException {
        this.logDAO = new SystemLogDAO();
    }

    public void recordAction(int id, String actionType, LocalDateTime date) {
        System.out.println("User ID: " + id + ", Action: " + actionType + ", Date: " + date);
        logDAO.save(id, actionType, date);
    }
    
}
