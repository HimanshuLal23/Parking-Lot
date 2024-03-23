package Factory;

import Model.Spots.Spot;
import Model.Ticket;
import Model.Vehicle;

import java.time.LocalTime;

public class TicketFactory {
    public static Ticket createTicketObject(Vehicle vehicle, LocalTime entryTime, int floorNumber, Spot spot) {
        return new Ticket(vehicle, entryTime,spot.getSpotId(),floorNumber);
    }
}
