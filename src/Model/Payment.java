package Model;

import java.util.UUID;

public class Payment {
    private PaymentMode paymentMode;
    private Ticket ticket;
    private boolean success;
    private double price;
    private UUID paymentId;

    public Payment(PaymentMode paymentMode, Ticket ticket, boolean success, double price) {
        this.paymentId = UUID.randomUUID();
        this.paymentMode = paymentMode;
        this.ticket = ticket;
        this.success = success;
        this.price = price;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean isSuccess() {
        return success;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public double getPrice() {
        return price;
    }
}
