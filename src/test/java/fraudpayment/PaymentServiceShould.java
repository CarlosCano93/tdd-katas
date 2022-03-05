package fraudpayment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceShould {

    private static final PaymentDetails PAYMENT_DETAILS = new PaymentDetails();
    private static final User USER = new User();

    @Mock
    private FraudService fraudService;
    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    PaymentService paymentService;

    @Test
    void thrown_an_exception_if_paid_is_fraudulent() {
        when(fraudService.isFraudulent(USER, PAYMENT_DETAILS))
                .thenReturn(true);


        assertThrows(RuntimeException.class,
                () -> paymentService.processPayment(USER, PAYMENT_DETAILS));
    }

    @Test
    void call_to_payment_gateway_if_payment_is_legit() {
        when(fraudService.isFraudulent(USER, PAYMENT_DETAILS))
                .thenReturn(false);

        paymentService.processPayment(USER, PAYMENT_DETAILS);

        verify(paymentGateway).payWith(PAYMENT_DETAILS);
    }

    @Test
    void do_not_call_to_payment_gateway_if_payment_is_fraudulent() {
        when(fraudService.isFraudulent(USER, PAYMENT_DETAILS))
                .thenReturn(true);

        assertThrows(RuntimeException.class,
                () -> paymentService.processPayment(USER, PAYMENT_DETAILS));
        verifyNoInteractions(paymentGateway);
    }
}
