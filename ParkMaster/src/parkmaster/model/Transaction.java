/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

/**
 *
 * @author rolas
 *
 * Represents a transaction in the system.
 */
import java.util.Date;

public class Transaction {
    private int id;
    private float amount;
    private String paymentMethod;
    private Date date;
    private String status;
    private String transactionType;
    private int reservationId;

    public boolean processPayment() {
         this.status = "Completed";
        System.out.println("Payment processed: " + amount);
        return true;
    }
    
    public String generateReceipt() {
        // Logic to generate a receipt
        return "Receipt for transaction ID: " + id;
    }

    public boolean refund() {
        this.status = "Refunded";
        System.out.println("Transaction refunded: " + amount);
        return true;
    }
}