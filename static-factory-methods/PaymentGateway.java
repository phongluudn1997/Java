public interface PaymentGateway {
    void processPayment(double amount);

    static PaymentGateway forRegion(String countryCode) {
        switch (countryCode) {
            case "US":
                return new StripeGateway();
            case "VN":
                return new VNPayGateway();
        }
        return new DefaultGateway();
    }
}

PaymentGateway paymentGateway = PaymentGateway.forRegion("US");

class StripeGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing USD via Stripe");
    }
}

class VNPayGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing VND via VNPay");
    }

}

class DefaultGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing default");
    }

}
