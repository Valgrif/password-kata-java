package org.example;

public class PasswordValidator {
    public static boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (notContainLowerChar(password)) {
            return false;
        }
        throw new RuntimeException("Not implemented yet");

    }

    private static boolean notContainLowerChar(String password) {
        return password.equals(password.toUpperCase());
    }

}

