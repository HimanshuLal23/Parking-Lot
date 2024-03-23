package Model.Spots;

import Model.Vehicle;
import Model.VehicleType;

import java.util.UUID;

public abstract class Spot {
    private UUID spotId;
    private boolean available;
    private VehicleType vehicleType;
    private Double price;
    public Spot(VehicleType vehicleType) {
        this.spotId = UUID.randomUUID();
        this.available = true;
        this.vehicleType = vehicleType;
        this.price = null;
    }

    public UUID getSpotId() {
        return spotId;
    }

    public boolean isAvailable() {
        return available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setAvailable() {
        this.available = true;
    }

    public void setUnavailable() {
        this.available = false;

    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    protected abstract Double getPrice();
    protected Double setPrice() {
        this.price = getPrice();
        return this.price;
    }
}
