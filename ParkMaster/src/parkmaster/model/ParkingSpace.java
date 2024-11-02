/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

/**
 *
 * @author rolas
 *
 * Represents a parking space in the system.
 */
public class ParkingSpace {
    private int id;
    private String type;
    private String status;
    private ParkingLot parkingLot;

    /**
     * Constructor for creating a ParkingSpace object.
     *
     * @param id        the parking space ID
     * @param type      the type of the parking space (e.g., Regular, VIP)
     * @param status    the status of the parking space (e.g., Available, Occupied, Reserved)
     * @param parkingLot the parking lot the space belongs to
     */
    public ParkingSpace(int id, String type, String status, ParkingLot parkingLot) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.parkingLot = parkingLot;
    }

    /**
     * Checks if the parking space is available.
     *
     * @return true if the space is available, false otherwise
     */
    public boolean checkAvailability() {
        return "Available".equals(this.status);
    }

    /**
     * Changes the status of the parking space.
     *
     * @param newStatus the new status of the parking space
     */
    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    public void reserveForMaintenance() {
        this.status = "Under Maintenance";
    }

    public int getId() {
        return id;
    }
}
