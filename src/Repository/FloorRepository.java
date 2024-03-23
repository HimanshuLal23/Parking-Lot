package Repository;

import Model.Floor;

import java.util.ArrayList;
import java.util.List;

public class FloorRepository {
    private static List<Floor> floors;
    private FloorRepository() {
        floors = new ArrayList<>();
    }
    private static class Holder {
        public static FloorRepository instance = new FloorRepository();
    }
    public static FloorRepository getInstance() {
        return Holder.instance;
    }
    public static void addFloor(int totalSpots,int floorNumber) {
        floors.add(new Floor(totalSpots,floorNumber));
    }

    public static void addFloor(Floor floor) {
        floors.add(floor);
    }

    public static List<Floor> getFloors() {
        return floors;
    }
}
