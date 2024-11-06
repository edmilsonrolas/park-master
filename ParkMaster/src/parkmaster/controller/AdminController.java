/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.controller;

import java.sql.SQLException;
import java.util.Date;
import parkmaster.model.Admin;
import parkmaster.model.User;
import parkmaster.service.AuthenticationService;
import parkmaster.session.Session;
import parkmaster.util.SystemLogs;

/**
 *
 * @author rolas
 */
public class AdminController {
    private final AuthenticationService authService;

    public AdminController() throws SQLException {
        this.authService = new AuthenticationService();
    }

    /**
     * Cria a conta do Administrador do Sistema.
     *
     * @param name     o nome do Administrador
     * @param email    o email do Administrador
     * @param password a password do Administrador
     * @param phoneNumber o celular do Administrador
     * @return 
     */
    public Admin createAdminAccount(String name, String email, String password, String phoneNumber) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        // Lógica para salvar o admin na base de dados
        return admin;
    }

    public boolean login(String email, String password) {
        Admin admin = findAdminByEmail(email);
        return admin != null && authService.login(admin, email, password);
    }
    
    public void logout(Admin admin) {
        authService.logout(admin);
    }
    
    public void manageUserAccount(User user) {
        // Lógica para editar ou remover um utilizador existente
    }

    public void viewSystemReports() {
        // Lógica para gerar e exibir relatórios do sistema
    }
    
    private Admin findAdminByEmail(String email) {
        // Lógica para encontrar o Admin na base de dados
        return null;
    }
}
