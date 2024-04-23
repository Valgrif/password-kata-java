package org.example.kata.password;

import java.util.List;

public class PasswordChecker {
    public static void check(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must have at least 8 characters length");
        }
        if (notContainLowerChar(password)) {
            throw new IllegalArgumentException("Password must contain at least a lower character");
        }
        if (notContainUpperChar(password)) {
            throw new IllegalArgumentException("Password must contain at least an upper character");
        }
        if (notContainNumber(password)) {
            throw new IllegalArgumentException("Password must contain at least a number");
        }
        if (notContainSpecialChar(password)) {
            throw new IllegalArgumentException("Password must contain at least a special character");
        }
    }

    private static boolean notContainSpecialChar(String password) {
        List<Character> specialChars = List.of('?', '_', '!', '-', '*', '(', ')', '[', ']', '{', '}', '+');
        return password.chars().mapToObj(c -> (char) c).noneMatch(specialChars::contains);
    }

    private static boolean notContainNumber(String password) {
        return password.chars().noneMatch(Character::isDigit);
    }

    private static boolean notContainUpperChar(String password) {
        return password.equals(password.toLowerCase());
    }

    private static boolean notContainLowerChar(String password) {
        return password.equals(password.toUpperCase());
    }

}

