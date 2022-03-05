package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addDeposit(String date, int amount) {
        transactions.add(new Transaction(date, amount));
    }

    public void addWithdraw(String date, int amount) {
        transactions.add(new Transaction(date, -amount));
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}

record Transaction(String date, int amount) {}
