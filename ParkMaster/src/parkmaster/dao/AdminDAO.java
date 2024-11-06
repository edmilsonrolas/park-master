/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import parkmaster.model.Admin;

/**
 *
 * @author rolas
 */
public class AdminDAO {
    private final Connection connection;

    public AdminDAO() throws SQLException {
        this.connection = SQLiteDBConnection.getConnection();
    }
    
    public void save(Admin admin) throws SQLException {
        String sql = "INSERT INTO Admin (name, email, password, phoneNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, admin.getName());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3, admin.getPassword());
            pstmt.setString(4, admin.getPhoneNumber());
//            pstmt.setDate(5, admin.getHireDate());
            pstmt.executeUpdate();
        }
    }
    
    /**
     * Obtém um cliente da base de dados com base no seu email.
     *
     * @param email do Administrador a ser obtido.
     * @return O objecto admin com o email especificado.
     * @throws SQLException Se ocorrer um erro durante a consulta.
     */
    public Admin findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setPhoneNumber(rs.getString("phoneNumber"));
                return admin;
            }
        }
        return null;
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
