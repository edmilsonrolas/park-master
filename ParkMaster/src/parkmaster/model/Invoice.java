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
public class Invoice {
    private int id;
    private int transactionId;
    private Date issueDate;
    private float totalAmount;
    private boolean paid;

    public String generateInvoice() {
        return "Invoice ID: " + id + ", Total Amount: " + totalAmount;
    }

    public void sendInvoiceByEmail(String email) {
        System.out.println("Invoice sent to: " + email);
    }
}
