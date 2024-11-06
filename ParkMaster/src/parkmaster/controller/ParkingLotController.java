/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;

import parkmaster.model.ParkingLot;
import parkmaster.service.ParkingLotService;

/**
 *
 * @author rolas
 */
public class ParkingLotController {
     private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void addParkingLot(ParkingLot lot) {
        parkingLotService.addParkingLot(lot);
    }

    public void updateParkingLot(ParkingLot lot) {
        parkingLotService.updateParkingLot(lot);
    }

    public void deleteParkingLot(int lotId) {
        parkingLotService.removeParkingLot(lotId);
    }
}
