package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    /*
    Password correcto: será aquel que
        tenga minimo 8 caracteres
        Contenga al menos una minuscula
        Contenga al menos una mayuscula
        Contenga al menos un número
        Contegna al menos un caracter especial: ?_!-*()[]{}+
     */
    @Test
    void should_validate_a_password_contains_at_least_eight_characters(){
        //given
        String password = "algo";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void should_validate_a_password_contains_at_least_one_lower_character(){
        //given
        String password = "ALGOALGO";
        //when
        boolean actual = PasswordValidator.validate(password);
        //then
        Assertions.assertThat(actual).isFalse();
    }
}