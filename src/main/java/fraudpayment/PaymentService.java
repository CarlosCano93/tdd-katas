package fraudpayment;

/**
 * Given a user wants to bui her selected items
 * When she submits her payment details
 * Then we should process her payment
 * <p>
 * Acceptance criteria:
 * If payment is fraudulent, an exception should be thrown.
 * Payment should only be sent to the payment gateway when payment is legit
 */
public class PaymentService {

    private final FraudService fraudService;
    private final PaymentGateway paymentGateway;

    public PaymentService(FraudService fraudService, PaymentGateway paymentGateway) {
        this.fraudService = fraudService;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {

        if (fraudService.isFraudulent(user, paymentDetails))
            throw new RuntimeException();

        paymentGateway.payWith(paymentDetails);
    }
}

class FraudService {

    public boolean isFraudulent(User user, PaymentDetails paymentDetails) {
        throw new UnsupportedOperationException();
    }
}

class PaymentGateway {

    public void payWith(PaymentDetails paymentDetails) {
        throw new UnsupportedOperationException();
    }
}

record User() {}

record PaymentDetails() {}
