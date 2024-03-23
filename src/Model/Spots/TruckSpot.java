package Model.Spots;

import Model.Spots.Spot;
import Model.VehicleType;

public class TruckSpot extends Spot {
    public Double getPrice() {
        return 5.25;
    }

    public TruckSpot() {
        super(VehicleType.Truck);
    }
}
