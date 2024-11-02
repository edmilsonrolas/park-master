/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

import java.util.Date;

/**
 *
 * @author rolas
 */
public class Notification {
    private int id;
    private String message;
    private Date sentDate;
    private int customerId;
    private String type;
    private String priority;

    public void sendNotification() {
        System.out.println("Notification sent to customer ID: " + customerId);
    }

    public void scheduleNotification(Date date) {
        this.sentDate = date;
        System.out.println("Notification scheduled for: " + date);
    }
}
