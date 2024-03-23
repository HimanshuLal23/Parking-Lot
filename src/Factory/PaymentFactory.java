package Factory;

import Model.Payment;
import Model.PaymentMode;
import Model.Ticket;

public class PaymentFactory {
    public static Payment createPaymentObject(PaymentMode paymentMode,Ticket ticket,boolean success,double price) {
        return new Payment(paymentMode, ticket, success, price);
    }
}
