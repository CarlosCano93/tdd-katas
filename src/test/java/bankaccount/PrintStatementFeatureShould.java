package bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeatureShould {

    @Mock private Console console;
    @Mock private Clock clock;

    private BankAccountService bankAccountService;

    @BeforeEach
    void setUp() {
        bankAccountService = new BankAccountService(
                new TransactionRepository(),
                new StatementPrinter(console),
                clock);
    }

    @Test
    void print_statement_with_transactions_in_reverse_order_by_date() {
        given(clock.getZone())
                .willReturn(ZoneId.systemDefault());
        given(clock.instant()).willReturn(
                Instant.parse("2022-02-01T00:00:00.00Z"),
                Instant.parse("2022-02-04T00:00:00.00Z"),
                Instant.parse("2022-02-05T00:00:00.00Z"));

        bankAccountService.deposit(1000);
        bankAccountService.withdraw(100);
        bankAccountService.deposit(500);

        bankAccountService.printStatement();

        verify(console).print("DATE | AMOUNT | BALANCE");
        verify(console).print("2022-02-05 | 500 | 1400");
        verify(console).print("2022-02-04 | -100 | 900");
        verify(console).print("2022-02-01 | 1000 | 1000");
    }
}
