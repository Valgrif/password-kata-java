package org.example.kata.bank;

public class SystemPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
