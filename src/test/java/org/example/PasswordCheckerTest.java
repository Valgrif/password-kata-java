package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordCheckerTest {
    @Test
    void should_check_a_password_contains_at_least_eight_characters() {
        //given
        String password = "Alga!g0";
        //when+then
        Assertions.assertThatThrownBy(() -> PasswordChecker.check(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password must have at least 8 characters length");
    }

    @Test
    void should_check_a_password_contains_at_least_one_lower_character() {
        //given
        String password = "ALGOALGO";
        //when+then
        Assertions.assertThatThrownBy(() -> PasswordChecker.check(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password must contain at least a lower character");
    }

    @Test
    void should_check_a_password_contains_at_least_one_upper_character() {
        //given
        String password = "algoalgo";
        //when
        Assertions.assertThatThrownBy(() -> PasswordChecker.check(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password must contain at least an upper character");
    }

    @Test
    void should_check_a_password_contains_at_least_one_number() {
        //given
        String password = "algoalgO";
        //when+then
        Assertions.assertThatThrownBy(() -> PasswordChecker.check(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password must contain at least a number");
    }

    @Test
    void should_check_a_password_contains_at_least_one_special_character() {
        //given
        String password = "alg0algO";
        //when+then
        Assertions.assertThatThrownBy(() -> PasswordChecker.check(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password must contain at least a special character");
    }

    @Test
    void should_check_a_correct_password() {
        String password = "Algoa!g0";

        Assertions.assertThatNoException().isThrownBy(() -> PasswordChecker.check(password));
    }
}