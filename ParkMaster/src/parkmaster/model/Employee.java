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
public abstract class Employee extends User {
    protected Date hireDate;
    
    public void manageParkingLot() {
        // Lógica de gestão do parque
    }
    // Método abstracto para monitorização de transações    
    public abstract void monitorTransactions();
    
    public void viewReports() {
        // Lógica para visualizar relatórios
    }
}
