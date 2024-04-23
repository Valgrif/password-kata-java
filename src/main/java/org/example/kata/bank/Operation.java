package org.example.kata.bank;

public record Operation(int amount, String date, int balance) {
    public String toRow() {
        return date + " | " + amount + " | " + balance;
    }

}
