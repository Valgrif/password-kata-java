package org.example.kata.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemClock implements Clock {
    private static final DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String now() {
        return LocalDate.now().format(formater);
    }
}
