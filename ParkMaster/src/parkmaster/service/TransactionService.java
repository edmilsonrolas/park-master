/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.service;

import java.time.LocalDateTime;
import java.util.List;
import parkmaster.dao.TransactionDAO;
import parkmaster.model.Transaction;

/**
 *
 * @author rolas
 */
public class TransactionService {
    private final TransactionDAO transactionDAO;

    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    /**
     * Monitoriza transações em um intervalo de datas especificado.
     *
     * @param startDate Data inicial do intervalo de monitorização
     * @param endDate   Data final do intervalo de monitorização
     * @return Lista de transações dentro do intervalo de datas
     */
    public List<Transaction> monitorTransactionsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionDAO.findTransactionsByDateRange(startDate, endDate);
    }

    /**
     * Monitoriza transações com base no status específico.
     *
     * @param status Status da transação a ser monitorizada (ex.: "Completed", "Pending", "Failed")
     * @return Lista de transações com o status especificado
     */
    public List<Transaction> monitorTransactionsByStatus(String status) {
        return transactionDAO.findTransactionsByStatus(status);
    }

    /**
     * Monitoriza transações associadas a um parque de estacionamento específico.
     *
     * @param parkingLotId ID do parque de estacionamento
     * @return Lista de transações associadas ao parque especificado
     */
    public List<Transaction> monitorTransactionsByParkingLot(int parkingLotId) {
        return transactionDAO.findTransactionsByParkingLot(parkingLotId);
    }
}
