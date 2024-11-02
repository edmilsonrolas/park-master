/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;

import java.util.Date;
import parkmaster.model.ParkingLot;
import parkmaster.model.ParkingManager;
import parkmaster.service.AuthenticationService;
import parkmaster.session.Session;
import parkmaster.util.SystemLogs;

/**
 *
 * @author rolas
 */
public class ParkingManagerController {
    private final AuthenticationService authService = new AuthenticationService();
    
    public boolean login(String email, String password) {
        ParkingManager manager = findManagerByEmail(email);
        return manager != null & authService.login(manager, email, password);
    }
    
    public void monitorTransactions(ParkingManager manager) {
        // Lógica para monitorar as transações feitas no parque que o manager gerencia
    }

    public void manageParkingLot(ParkingManager manager, ParkingLot lot) {
        manager.manageParkingLot();
        // Lógica para permitir que o manager faça mudanças no parque
    }

    public void generateOccupancyReport(ParkingManager manager, ParkingLot lot) {
        System.out.println(lot.generateOccupancyReport());
    }
    
    public void logout(ParkingManager manager) {
        authService.logout(manager);
    }

    private ParkingManager findManagerByEmail(String email) {
        // Lógica para encontrar o Manager no banco de dados
        return null;
    }
}
