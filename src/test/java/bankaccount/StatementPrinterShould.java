package bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    @Mock private Console console;
    @InjectMocks private StatementPrinter statementPrinter;

    @Test
    void print_the_header_as_first_line() {
        statementPrinter.print(List.of());

        verify(console).print("DATE | AMOUNT | BALANCE");
    }

    @Test
    void print_all_transactions_in_reverse_order() {
        statementPrinter.print(List.of(
                new Transaction("2022-02-01", 1000),
                new Transaction("2022-02-04", -100),
                new Transaction("2022-02-05", 500)
        ));

        verify(console).print("DATE | AMOUNT | BALANCE");
        verify(console).print("2022-02-05 | 500 | 1400");
        verify(console).print("2022-02-04 | -100 | 900");
        verify(console).print("2022-02-01 | 1000 | 1000");
    }
}
