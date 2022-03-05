package bankaccount;

import java.time.Clock;

public class ApplicationMain {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountService(
                new TransactionRepository(),
                new StatementPrinter(new Console()),
                Clock.systemDefaultZone());

        bankAccountService.deposit(1000);
        bankAccountService.withdraw(100);
        bankAccountService.deposit(500);

        bankAccountService.printStatement();
    }
}
