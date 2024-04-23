package org.example.kata.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AccountTest {

    /* Un cliente hace un deposito de 1000€ el 10-01-2012
     Luego hace un deposito de 2000€ el 13-01-2012
     Retira 500€ el 14-01-2012
     Al imprimir su estracto bancario vería lo siguiente:

    Date       || Amount || Balance
    14/01/2012 || -500   || 2500
    13/01/2012 || 2000   || 3000
    10/01/2012 || 1000   || 1000

    */

    @Test
    void should_print_statement_with_every_action_of_client_account() {
        Printer mockPrinter = Mockito.mock(Printer.class);
        Clock mockClock = Mockito.mock(Clock.class);
        Account account = new Account(mockClock, mockPrinter);
        Mockito.when(mockClock.now())
                .thenReturn("10/01/2012")
                .thenReturn("13/01/2012")
                .thenReturn("14/01/2012");

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        String expected = """
                Date | Amount | Balance
                14/01/2012 | -500 | 2500
                13/01/2012 | 2000 | 3000
                10/01/2012 | 1000 | 1000""";

        Mockito.verify(mockPrinter).print(Mockito.eq(expected));


    }

}
