package org.example;

import org.example.kata.bank.Account;
import org.example.kata.bank.SystemClock;
import org.example.kata.bank.SystemPrinter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SystemClock clock = new SystemClock();
        SystemPrinter printer = new SystemPrinter();
        Account account = new Account(clock, printer);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

    }
}