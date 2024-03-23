package Services;

import Factory.PaymentFactory;
import Model.Payment;
import Model.PaymentMode;
import Model.Spots.Spot;
import Model.Ticket;
import Repository.FloorRepository;
import Repository.PaymentRepository;
import Exception.ParkingLotException;
import Repository.SpotRepository;

import java.time.LocalTime;
import java.util.UUID;

import static Exception.ParkingLotExceptionType.PaymentNotDoneException;

public class ExitGateService {
    private Ticket ticket;
    private PaymentMode paymentMode;
    private PaymentRepository paymentRepository;
    private SpotRepository spotRepository;

    public ExitGateService(Ticket ticket,PaymentMode paymentMode) {
        this.ticket = ticket;
        this.paymentMode = paymentMode;
        this.paymentRepository = PaymentRepository.getInstance();
        this.spotRepository = SpotRepository.getInstance();
    }
    public Payment doPayment() {
        int totalTime = LocalTime.now().plusHours(2).getHour()-ticket.getEntryTime().getHour();
        double price = totalTime*1.25;
        Payment payment = PaymentFactory.createPaymentObject(paymentMode,ticket,true,price);
        paymentRepository.addPayment(payment);
        return payment;
    }

    public String freeParkingSpot(Payment payment) throws ParkingLotException{
        if(!payment.isSuccess()) {
            throw new ParkingLotException("Payment not done exception",PaymentNotDoneException);
        }
        String exitMessage = "Come visit us again, you paid $" + payment.getPrice() ;
        Ticket ticket = payment.getTicket();
        UUID spotId = ticket.getSpotId();
        for(var spot:spotRepository.getSpots()) {
            if(spot.equals(spotId)) {
                spot.setAvailable();
            }
        }
        return exitMessage;
    }
}
