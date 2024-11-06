/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import parkmaster.model.Transaction;

/**
 *
 * @author rolas
 */
public class TransactionDAO {

    private final Connection connection;

    public TransactionDAO() throws SQLException {
        this.connection = SQLiteDBConnection.getConnection();
    }

    public List<Transaction> findTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        String query = "SELECT * FROM Transactions WHERE date BETWEEN ? AND ?";
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
//            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                // Definir atributos de Transaction a partir dos resultados
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar transações: " + e.getMessage());
        }
        return transactions;
    }

    public List<Transaction> findTransactionsByStatus(String status) {
        String query = "SELECT * FROM Transactions WHERE status = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                // Definir atributos de Transaction a partir dos resultados
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar transações: " + e.getMessage());
        }
        return transactions;
    }

    public List<Transaction> findTransactionsByParkingLot(int parkingLotId) {
        String query = "SELECT * FROM Transactions WHERE parking_lot_id = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, parkingLotId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                // Definir atributos de Transaction a partir dos resultados
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar transações: " + e.getMessage());
        }
        return transactions;
    }

    /**
     * Fecha a conexão com a base de dados.
     */
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<String> getTransactionStatusSummary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
