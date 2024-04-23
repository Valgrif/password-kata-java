package org.example.kata.bank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Account implements AccountService {
    private final Clock clock;
    private final List<Operation> operations = new ArrayList<>();
    private final Printer printer;
    private int total = 0;


    public Account(Clock clock, Printer printer) {
        this.clock = clock;

        this.printer = printer;
    }

    @Override
    public void deposit(int amount) {
        total += amount;
        Operation operation = new Operation(amount, clock.now(), total);
        operations.add(operation);
    }

    @Override
    public void withdraw(int amount) {
        deposit(-amount);

    }

    @Override
    public void printStatement() {
        String header = "Date | Amount | Balance\n";
        Comparator<Operation> operationSortedByDate = Comparator.comparing(Operation::date).reversed();
        String rows = operations.stream().sorted(operationSortedByDate).map(Operation::toRow)
                .collect(Collectors.joining("\n"));
        String statement = header + rows;
        printer.print(statement);


    }
    
}
