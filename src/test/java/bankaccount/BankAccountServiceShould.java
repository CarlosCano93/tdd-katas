package bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceShould {

    public static final String INSTANT_DATE = "2022-02-05T00:00:00.00Z";
    public static final String STRING_DATE = "2022-02-05";
    @Mock private TransactionRepository transactionRepository;
    @Mock private StatementPrinter statementPrinter;
    @Mock private Clock clock;

    @InjectMocks
    private BankAccountService bankAccountService;

    @Test
    void store_a_deposit_transaction() {
        given(clock.instant())
                .willReturn(Instant.parse(INSTANT_DATE));
        given(clock.getZone())
                .willReturn(ZoneId.systemDefault());

        bankAccountService.deposit(100);

        verify(transactionRepository).addDeposit(STRING_DATE, 100);
    }

    @Test
    void store_a_withdraw_transaction() {
        given(clock.instant())
                .willReturn(Instant.parse(INSTANT_DATE));
        given(clock.getZone())
                .willReturn(ZoneId.systemDefault());

        bankAccountService.withdraw(100);

        verify(transactionRepository).addWithdraw(STRING_DATE, 100);
    }

    @Test
    void print_statement() {
        List<Transaction> transactions = List.of(
                new Transaction(STRING_DATE, 100));

        given(transactionRepository.getAllTransactions())
                .willReturn(transactions);

        bankAccountService.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
