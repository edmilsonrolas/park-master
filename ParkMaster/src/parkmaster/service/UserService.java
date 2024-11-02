/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.service;

import java.time.LocalDateTime;
import java.util.Date;
import parkmaster.model.User;
import parkmaster.util.SystemLogs;

/**
 *
 * @author rolas
 */
public class UserService {
    
    /**
     * Edita o perfil do utilizador com novos dados.
     *
     * @param user     o utilizador a ser editado
     * @param name     o novo nome
     * @param email    o novo email
     * @param password a nova password
     */
    public void editProfile(User user, String name, String email, String password) {
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setLastPasswordReset(LocalDateTime.now());
        
        SystemLogs.recordAction(user.getId(), "Edit Profile", LocalDateTime.now());
        System.out.println("Perfil actualizado para o utilizador: " + user.getEmail());
    }

    /**
     * Redefine a password do utilizador e actualiza a data de redefinição.
     *
     * @param user        o utilizador a ser actualizado
     * @param newPassword a nova password a ser definida
     */
    public void resetPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        user.setLastPasswordReset(LocalDateTime.now());

        SystemLogs.recordAction(user.getId(), "Password Reset", LocalDateTime.now());
        System.out.println("Password redefinida para o utilizador: " + user.getEmail());
    }
}
