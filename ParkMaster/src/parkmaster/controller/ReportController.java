/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;

import java.time.LocalDateTime;
import java.util.List;
import parkmaster.model.ParkingLot;
import parkmaster.model.Transaction;
import parkmaster.service.ReportService;

/**
 *
 * @author rolas
 */
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Exibe o relatório de ocupação de estacionamento.
     */
    public void viewOccupancyReport() {
        List<ParkingLot> occupancyReport = reportService.generateOccupancyReport();
        displayReport(occupancyReport);
    }

    /**
     * Exibe o relatório financeiro para o período especificado.
     *
     * @param startDate Data inicial do relatório
     * @param endDate   Data final do relatório
     */
    public void viewFinancialReport(LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> financialReport = reportService.generateFinancialReport(startDate, endDate);
        displayReport(financialReport);
    }

    /**
     * Exibe o resumo das transações por status.
     */
    public void viewStatusSummaryReport() {
        List<String> statusSummary = reportService.generateStatusSummaryReport();
        displayReport(statusSummary);
    }

    /**
     * Exibe os dados do relatório (simulado aqui com print no console).
     * No caso de uma GUI, chamaria métodos de atualização da interface.
     */
    private <T> void displayReport(List<T> reportData) {
        for (T data : reportData) {
            System.out.println(data);
            // Aqui, podemos adicionar lógica para exibir o relatório em uma GUI
        }
    }
}
