/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.service;

import java.time.LocalDateTime;
import java.util.List;
import parkmaster.dao.ParkingLotDAO;
import parkmaster.dao.TransactionDAO;
import parkmaster.model.ParkingLot;
import parkmaster.model.Transaction;

/**
 *
 * @author rolas
 */
public class ReportService {
    private final TransactionDAO transactionDAO;
    private final ParkingLotDAO parkingLotDAO;

    public ReportService(TransactionDAO transactionDAO, ParkingLotDAO parkingLotDAO) {
        this.transactionDAO = transactionDAO;
        this.parkingLotDAO = parkingLotDAO;
    }

    /**
     * Gera um relatório de ocupação dos parques de estacionamento.
     *
     * @return Lista com os dados de ocupação de cada parque
     */
    public List<ParkingLot> generateOccupancyReport() {
        // Lógica para gerar e retornar dados de ocupação de estacionamentos
        return parkingLotDAO.findAllParkingLotsWithOccupancy();
    }

    /**
     * Gera um relatório financeiro com base nas transações entre as datas especificadas.
     *
     * @param startDate Data inicial do relatório
     * @param endDate   Data final do relatório
     * @return Lista de transações financeiras no período
     */
    public List<Transaction> generateFinancialReport(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionDAO.findTransactionsByDateRange(startDate, endDate);
    }

    /**
     * Gera um relatório resumido por status das transações (ex.: "Completed", "Pending").
     *
     * @return Resumo de contagem por status de transação
     */
    public List<String> generateStatusSummaryReport() {
        return transactionDAO.getTransactionStatusSummary();
    }
}
