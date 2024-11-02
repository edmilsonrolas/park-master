/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import parkmaster.model.Customer;

/**
 * Classe DAO para a entidade Customer.
 * 
 * Esta classe é responsável por realizar operações de acesso a dados relacionadas aos clientes na base de dados.
 * Ela fornece métodos para inserir, atualizar, excluir, obter um cliente por ID e obter todos os clientes.
 * 
 * @author rolas
 */
public class CustomerDAO {
    private final Connection connection;

    /**
     * Construtor da classe CustomerDAO.
     *
     * @throws SQLException Se ocorrer um erro durante a inicialização da conexão.
     */
    public CustomerDAO() throws SQLException {
        connection = SQLiteDBConnection.getConnection();
    }

    /**
     * Obtém um cliente da base de dados com base no seu email.
     *
     * @param customerID O ID de cliente do cliente a ser obtido.
     * @return O objeto Cliente com o ID de cliente especificado.
     * @throws SQLException Se ocorrer um erro durante a consulta.
     */
    public Customer findCustomerByEmail(String email) {
        String query = "SELECT * FROM customers WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void save(Customer customer) throws SQLException {
        String query = "INSERT INTO customers (name, email, password, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPassword());
            stmt.setString(4, customer.getPhoneNumber());
            stmt.executeUpdate();
        }
    }
}

