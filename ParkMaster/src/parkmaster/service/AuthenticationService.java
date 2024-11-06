/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import parkmaster.model.User;
import parkmaster.session.Session;
import parkmaster.util.SystemLogs;

/**
 *
 * @author rolas
 */
public class AuthenticationService {
    private final SystemLogs log;
    private static final int MAX_FAILED_ATTEMPTS = 3;

    public AuthenticationService() throws SQLException {
        this.log = new SystemLogs();
    }
    
    /**
     * Autentica o utilizador ao comparar o email e a password.
     *
     * @param user o utilizador
     * @param email    o email fornecido para autenticação
     * @param password a password fornecida para autenticação
     * @return true se a autenticação for bem-sucedida, false caso contrário
     */
    public boolean login(User user, String email, String password) {
        LocalDateTime currentDate = LocalDateTime.now();
        
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            user.resetFailedLoginAttempts();
            user.setLastLogin(currentDate);
            Session.startSession(user);
            log.recordAction(user.getId(), user.getClass().getSimpleName() + " Login", currentDate);
            return true;
        } else {
            user.increaseFailedLoginAttempts();
            log.recordAction(user.getId(), "Login Failed", currentDate);
            System.out.println("Tentativa de login falhou.");
            
            // Verifica se atingiu o limite de tentativas
            if (user.getFailedLoginAttempts() >= MAX_FAILED_ATTEMPTS) {
                user.lockAccount();
                log.recordAction(user.getId(), "Account Locked", currentDate);
                System.out.println("Conta bloqueada devido a tentativas falhadas.");
            }
            return false;
        }
    }

    public void logout(User user) {
        if (Session.isAuthenticated()) {
            log.recordAction(user.getId(), user.getClass().getSimpleName() + " Logout", LocalDateTime.now());
            Session.endSession();
        }
    }
    
    public void unlockAccount(User user) {
        user.unlockAccount();
        log.recordAction(user.getId(), "Account Unlocked", LocalDateTime.now());
    }
}
