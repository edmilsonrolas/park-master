/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;

import java.time.LocalDateTime;
import java.util.List;
import parkmaster.model.Transaction;
import parkmaster.service.TransactionService;

/**
 *
 * @author rolas
 */
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Monitoriza transações dentro de um intervalo de datas e retorna o resultado.
     *
     * @param startDate Data inicial do intervalo
     * @param endDate   Data final do intervalo
     * @return Lista de transações dentro do intervalo especificado
     */
    public List<Transaction> monitorTransactionsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> transactions = transactionService.monitorTransactionsByDate(startDate, endDate);
        displayTransactions(transactions);
        return transactions;
    }

    /**
     * Monitoriza transações com base no status e retorna o resultado.
     *
     * @param status Status da transação (ex.: "Completed", "Pending", "Failed")
     * @return Lista de transações com o status especificado
     */
    public List<Transaction> monitorTransactionsByStatus(String status) {
        List<Transaction> transactions = transactionService.monitorTransactionsByStatus(status);
        displayTransactions(transactions);
        return transactions;
    }

    /**
     * Monitoriza transações associadas a um parque específico e retorna o resultado.
     *
     * @param parkingLotId ID do parque de estacionamento
     * @return Lista de transações associadas ao parque especificado
     */
    public List<Transaction> monitorTransactionsByParkingLot(int parkingLotId) {
        List<Transaction> transactions = transactionService.monitorTransactionsByParkingLot(parkingLotId);
        displayTransactions(transactions);
        return transactions;
    }

    /**
     * Exibe transações na interface (console ou GUI).
     *
     * @param transactions Lista de transações a serem exibidas
     */
    private void displayTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            // No caso de GUI, aqui chamaríamos métodos da View para exibir os dados
        }
    }
}
