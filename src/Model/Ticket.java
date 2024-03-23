package Model;

import Model.Spots.Spot;

import java.time.LocalTime;
import java.util.UUID;

public class Ticket {
    private UUID ticketId;
    private Vehicle vehicle;
    private LocalTime entryTime;
    private UUID spotId;
    private int floorNumber;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public UUID getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Ticket(Vehicle vehicle, LocalTime entryTime, UUID spotId, int floorNumber) {
        this.ticketId = UUID.randomUUID();
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.spotId = spotId;
        this.floorNumber = floorNumber;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicleId() {
        return vehicle;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }
}
