package bankaccount;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.print("DATE | AMOUNT | BALANCE");

        AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::print);
    }

    private String statementLine(Transaction transaction, AtomicInteger balance) {

        return transaction.date() + " | " +
                transaction.amount() + " | " +
                balance.addAndGet(transaction.amount());
    }
}
