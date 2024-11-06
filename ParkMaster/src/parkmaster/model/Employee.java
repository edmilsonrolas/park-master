/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * Classe abstracta para representar um Funcionário no sistema.
 * Fornece métodos comuns para gerir o parque e visualizar relatórios.
 * 
 * @author rolas
 */
public abstract class Employee extends User {
    protected LocalDateTime hireDate;
    
    public void viewReports() {
        // Lógica para visualizar relatórios
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }
    
}
