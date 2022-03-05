package bankaccount;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

/**
 * Bank application with following features:
 * - Deposit money
 * - Withdraw money
 * - Print bank statement to the console
 *
 * Statement Acceptance Criteria:
 *
 * DATE       | AMOUNT | BALANCE
 * 2022-02-05 | 500    | 1400
 * 2022-02-04 | -100   | 900
 * 2022-02-01 | 1000   | 1000
 *
 */
public class BankAccountService {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;
    private final Clock clock;

    public BankAccountService(final TransactionRepository transactionRepository,
                              final StatementPrinter statementPrinter,
                              final Clock clock) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
        this.clock = clock;
    }


    public void deposit(int amount) {
        transactionRepository.addDeposit(LocalDate.now(clock).toString(), amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addWithdraw(LocalDate.now(clock).toString(), amount);
    }

    public void printStatement() {
        List<Transaction> allTransactions = transactionRepository.getAllTransactions();
        statementPrinter.print(allTransactions);
    }
}
