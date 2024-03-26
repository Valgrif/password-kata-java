package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    /*
    Password correcto: será aquel que
        tenga minimo 8 caracteres (/)
        Contenga al menos una minuscula (/)
        Contenga al menos una mayuscula (/)
        Contenga al menos un número (/)
        Contenga al menos un caracter especial: ?_!-*()[]{}+
     */
    @Test
    void should_validate_a_password_contains_at_least_eight_characters() {
        //given
        String password = "Alga!g0";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_password_contains_at_least_one_lower_character() {
        //given
        String password = "ALGOALGO";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_password_contains_at_least_one_upper_character() {
        //given
        String password = "algoalgo";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_password_contains_at_least_one_number() {
        //given
        String password = "algoalgO";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_password_contains_at_least_one_special_character() {
        //given
        String password = "alg0algO";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_correct_password() {
        String password = "Algoa!g0";

        boolean actual = PasswordValidator.validate(password);

        Assertions.assertThat(actual).isTrue();
    }
}