package com.spring.springboot.helpers;

import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Version;

@Component
public class Encryption {
    private static final int COST_FACTOR = 6;
    private final BCrypt.Hasher hasher = BCrypt.with(Version.VERSION_2Y);

    public String getEncryptedPassword(String password) {
        String s = hasher.hashToString(COST_FACTOR, password.toCharArray());
        return s;
    }

    public boolean checkPassword(String passwordHash, String userInput) {
        if (passwordHash == null || passwordHash.isEmpty()) {
            return false;
        }

        return BCrypt.verifyer().verify(userInput.toCharArray(), passwordHash).verified;
    }
}
