/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

/**
 *
 * @author rolas
 *
 * Represents a reservation in the system.
 */
import java.util.Date;

public class Reservation {
    private int id;
    private Date startDate;
    private Date endDate;
    private String reservationType;
    private String status;
    private int customerId;
    private int parkingSpaceId;

    /**
     * Constructor for creating a Reservation object.
     *
     * @param startDate    the start date of the reservation
     * @param endDate      the end date of the reservation
     * @param status       the status of the reservation (e.g., Active, Canceled)
     * @param customerId
     * @param parkingSpaceId
     * @param reservationType
     */
    public Reservation(Date startDate, Date endDate, String status, int customerId, int parkingSpaceId, String reservationType) {    
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.customerId = customerId;
        this.parkingSpaceId = parkingSpaceId;
        this.reservationType = reservationType;
    }

    public Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void createReservation() {
        // Logic to create a reservation
        this.status = "Active";
        System.out.println("Reservation created for customer ID: " + customerId);
     }

    /**
     * Cancels a reservation by its ID.
     *
     * @param id the reservation ID
     */
    public void cancelReservation(int id) {
        // Logic to cancel a reservation
        this.status = "Cancelled";
        System.out.println("Reservation cancelled.");
    }

    public void extendReservation(Date newEndDate) {
        // Extender reserva
        this.endDate = newEndDate;
        System.out.println("Reservation extended to: " + newEndDate);
    }
    
    /**
     * Checks the status of a reservation.
     *
     * @return the status of the reservation
     */
    public String checkStatus() {
        return this.status;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

}
