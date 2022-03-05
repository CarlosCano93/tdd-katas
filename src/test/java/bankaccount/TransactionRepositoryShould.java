package bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionRepositoryShould {

    public static final String DATE = "2022-02-05";
    private final TransactionRepository transactionRepository = new TransactionRepository();

    @Test
    void store_a_deposit() {
        transactionRepository.addDeposit(DATE, 100);

        assertThat(transactionRepository.getAllTransactions().size())
                .isEqualTo(1);
        assertThat(transactionRepository.getAllTransactions().get(0))
                .isEqualTo(new Transaction(DATE, 100));
    }

    @Test
    void store_a_withdraw() {
        transactionRepository.addWithdraw(DATE, 100);

        assertThat(transactionRepository.getAllTransactions().size())
                .isEqualTo(1);
        assertThat(transactionRepository.getAllTransactions().get(0))
                .isEqualTo(new Transaction(DATE, -100));
    }
}
