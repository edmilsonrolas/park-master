/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

import java.time.LocalDateTime;
import java.util.Date;
import parkmaster.service.AuthenticationService;

/**
 *
 * @author rolas
 *
 * Representa um Utilizador no sistema.
 */
public abstract class User extends BaseEntity{
    private String phoneNumber;
    private String email;
    private String password;
    protected LocalDateTime lastLogin;
    protected LocalDateTime lastPasswordReset;
    protected int failedLoginAttempts;
    private boolean isLocked = false;

    
    public void increaseFailedLoginAttempts() {
        this.failedLoginAttempts++;
    }

    public void resetFailedLoginAttempts() {
        this.failedLoginAttempts = 0;
    }
    
    public void lockAccount() {
        this.isLocked = true;
    }

    public void unlockAccount() {
        this.isLocked = false;
        resetFailedLoginAttempts();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastPasswordReset(LocalDateTime lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public LocalDateTime getLastPasswordReset() {
        return lastPasswordReset;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }
    
}

