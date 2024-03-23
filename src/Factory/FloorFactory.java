package Factory;

import Model.Floor;

public class FloorFactory {
    private FloorFactory() {

    }
    public static Floor createFloor(int totalSpots,int floorNumber) {
        Floor floor = new Floor(totalSpots, floorNumber);
        return floor;
    }
}
