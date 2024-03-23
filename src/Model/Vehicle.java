package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Vehicle {
    private UUID vehicleId;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleId = UUID.randomUUID();
        this.vehicleType = vehicleType;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
