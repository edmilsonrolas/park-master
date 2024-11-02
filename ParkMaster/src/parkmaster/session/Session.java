/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.session;

import parkmaster.model.User;

/**
 *
 * @author rolas
 */
public class Session {
    private static boolean authenticated = false;
    private static User currentUser;
    
    public static void startSession(User user) {
        authenticated = true;
        currentUser = user;
        System.out.println("Session started for user: " + user.getName());
    }

    public static boolean isAuthenticated() {
        return authenticated;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static void endSession() {
        authenticated = false;
        currentUser = null;
        System.out.println("Session ended.");
    }
}
