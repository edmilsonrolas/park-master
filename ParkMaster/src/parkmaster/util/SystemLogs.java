/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.util;

import java.time.LocalDateTime;
import parkmaster.dao.SystemLogDAO;

/**
 *
 * @author rolas
 */
public class SystemLogs {

    public static void recordAction(int id, String actionType, LocalDateTime date) {
        System.out.println("User ID: " + id + ", Action: " + actionType + ", Date: " + date);
        SystemLogDAO.save(id, actionType, date);
    }
    
}
