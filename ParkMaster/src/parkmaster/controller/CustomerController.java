/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import parkmaster.dao.CustomerDAO;
import parkmaster.model.Customer;
import parkmaster.model.ParkingSpace;
import parkmaster.model.Reservation;
import parkmaster.service.AuthenticationService;
import parkmaster.session.Session;
import parkmaster.util.SystemLogs;

/**
 * Controlador para o Cliente (Customer).
 * 
 * Esta classe fornece métodos para realizar operações relacionadas aos clientes,
 * interagindo com a classe de acesso a dados (DAO) correspondente.
 * 
 * @author rolas
 */
public class CustomerController {
    private final AuthenticationService authService = new AuthenticationService();
    private final CustomerDAO customerDAO;

    /**
     * Construtor da classe CustomerController.
     * Inicializa a classe CustomerDAO.
     */
    public CustomerController() throws SQLException {
        try {
            customerDAO = new CustomerDAO();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar CustomerController", e);
        }
    }

    /**
     * Cria uma conta de Cliente.
     *
     * @param name     o nome do Cliente
     * @param email    o email do Cliente
     * @param password a password do Cliente
     * @param phoneNumber o celular do Cliente
     * @return 
     */
    public Customer createAccount(String name, String email, String password, String phoneNumber) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhoneNumber(phoneNumber);
        
        try {
            customerDAO.save(customer);
            System.out.println("Conta de cliente criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar conta de cliente.", e);
        }
        return customer;
    }
    
    public boolean login(String email, String password) {
        Customer customer = findCustomerByEmail(email);
        return customer != null && authService.login(customer, email, password);
    }

    public boolean reserveParkingSpace(Customer customer, ParkingSpace space) {
        if (!isAuthenticatedCustomer()) {
            System.out.println("Only authenticated customers can reserve parking spaces.");
            return false;
        }

        if (!isSpaceAvailable(space)) {
            System.out.println("Espaço não disponível.");
            return false;
        }

        Reservation reservation = createReservation(customer, space);
        updateSpaceStatus(space, "Occupied");

        System.out.println("Parking space reserved successfully for customer: " + customer.getName());
        
        return true;
    }
    
    private boolean isAuthenticatedCustomer() {
        return Session.isAuthenticated() && Session.getCurrentUser() instanceof Customer;
    }

    private boolean isSpaceAvailable(ParkingSpace space) {
        return space.checkAvailability();
    }
    
    private Reservation createReservation(Customer customer, ParkingSpace space) {
        Reservation reservation = new Reservation();
        reservation.createReservation();
        reservation.setCustomerId(customer.getId());
        reservation.setParkingSpaceId(space.getId());
        
        // Persistir a reserva na base de dados
        
        return reservation;
    }

    private void updateSpaceStatus(ParkingSpace space, String status) {
        space.changeStatus(status);
    }

    public List<Reservation> viewReservationHistory(Customer customer) {
        // Consulta à base de dados para obter o histórico
        return null;
    }
    
    public void logout(Customer customer) {
        authService.logout(customer);
    }

    private Customer findCustomerByEmail(String email) {
        // Lógica para encontrar o Customer no banco de dados
        return null;
    }

    /**
     * Fecha a conexão com a base de dados.
     */
    public void closeConnection() {
        customerDAO.closeConnection();
    }
}

