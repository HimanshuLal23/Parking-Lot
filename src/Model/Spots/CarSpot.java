package Model.Spots;

import Model.Spots.Spot;
import Model.VehicleType;

public class CarSpot extends Spot {
    public Double getPrice() {
        return 3.25;
    }
    public CarSpot() {
        super(VehicleType.Car);
    }
}
