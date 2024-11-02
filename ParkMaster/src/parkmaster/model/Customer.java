/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

import java.util.List;

/**
 * Representa um cliente do sistema.
 * 
 * Esta classe estende a classe abstrata Person e adiciona atributos específicos de um cliente,
 * como o ID de cliente, o estado de associação (membership status) e pontos de fidelidade.
 * 
 * @author rolas
 */
public class Customer extends User{
    private String preferredPaymentMethod;
    
    public void updatePreferredPaymentMethod(String newMethod) {
        this.preferredPaymentMethod = newMethod;
    }

    public void reserveParkingSpace() {
        // Lógica para reserva
    }

    // Método para consultar o histórico de transações do cliente
    public List<Transaction> getTransactionHistory() {
        List<Transaction> transactionList = null;
        // Lógica para retornar apenas as transações relacionadas ao cliente
        return transactionList;
    }
    
    public List<Reservation> viewReservationHistory() {
        return null;
    }
    
}

