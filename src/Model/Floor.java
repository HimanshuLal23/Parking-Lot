package Model;

import Model.Spots.Spot;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Spot> spots;
    private int totalSpots;
    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Floor(int totalSpots,int floorNumber) {
        this.totalSpots = totalSpots;
        this.floorNumber = floorNumber;
        spots = new ArrayList<>();
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public void addSpot(Spot spot) throws ParkingLotException {
        if(spots.size()==totalSpots) {
            throw new ParkingLotException("No more spots can be added to this floor", ParkingLotExceptionType.SpotLimitReachedException);
        }
        spots.add(spot);
    }
}
