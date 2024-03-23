package Services;

import Factory.TicketFactory;
import Model.Spots.Spot;
import Model.Ticket;
import Model.Vehicle;
import Repository.TicketRepository;

import java.time.LocalTime;

public class EntryGateService {
    private Vehicle vehicle;
    private LocalTime localTime;
    private TicketRepository ticketRepository;
    private Spot spot;
    private int floorNumber;

    public EntryGateService(Vehicle vehicle, LocalTime localTime,Spot spot,int floorNumber) {
        this.vehicle = vehicle;
        this.localTime = localTime;
        this.spot = spot;
        this.floorNumber = floorNumber;
        this.ticketRepository = TicketRepository.getInstance();
    }

    public Ticket generateTicket() {
        Ticket ticket = TicketFactory.createTicketObject(vehicle,localTime,floorNumber,spot);
        ticketRepository.addTicket(ticket);
        return ticket;
    }
}
