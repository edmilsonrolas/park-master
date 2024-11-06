/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author rolas
 */
public class SystemLogDAO {
    private final Connection connection;

    public SystemLogDAO() throws SQLException {
        this.connection = SQLiteDBConnection.getConnection();
    }
    
    public void save(int id, String actionType, LocalDateTime date) {
        String query = "INSERT INTO SystemLogs (userId, actionType, date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, actionType);
//            pstmt.setDate(3, new java.sql.Date(date.getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar log no banco de dados: " + e.getMessage());
        }
    }
    
    /**
     * Fecha a conexão com a base de dados.
     */
    public void closeConnection() {
        try {
            SQLiteDBConnection.closeConnection();
        } catch (SQLException e) {
        }
    }
    
}
