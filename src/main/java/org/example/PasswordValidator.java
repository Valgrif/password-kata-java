package org.example;

import java.util.List;

public class PasswordValidator {
    public static boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (notContainLowerChar(password)) {
            return false;
        }
        if (notContainUpperChar(password)) {
            return false;
        }
        if (notContainNumber(password)) {
            return false;
        }
        if (notContainSpecialChar(password)) {
            return false;
        }
        throw new RuntimeException("Not implemented yet");

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

