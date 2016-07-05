package com.example.services.security;

/**
 * Created by jconnors on 7/5/16.
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
