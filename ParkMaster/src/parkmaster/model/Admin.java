/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rolas
 */
public class Admin extends Employee {
    
    public void manageUser() {
        // Lógica para gestão de utilizadores
    }
    public void addParkingLot(ParkingLot lot) {
        // Lógica para adicionar um parque
    }

    public void createUser(User user) {
        // Lógica para criar um novo utilizador
    }

    public void deleteUser(int userId) {
        // Lógica para remover um utilizador
    }

    @Override
    public void monitorTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Transaction> monitorTransactionsByDate(Date startDate, Date endDate) {
        // Lógica específica para monitorizar por data
        return null;
    }

    public Map<String, List<Transaction>> monitorTransactionsByStatus() {
        // Lógica específica para monitorizar por status
        return null;
    }
    
    public List<Transaction> monitorTransactionsByParkingLot(int parkingLotId) {
        // Lógica para monitorizar transações por parque específico
        return null;
    }
}
