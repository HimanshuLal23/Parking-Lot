package Repository;

import Model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private static List<Payment> payments;
    private PaymentRepository() {
        payments = new ArrayList<>();
    }
    private static class Holder {
        public static PaymentRepository instance = new PaymentRepository();
    }
    public static PaymentRepository getInstance() {
        return PaymentRepository.Holder.instance;
    }
    public static void addPayment(Payment payment) {
        payments.add(payment);
    }
}
