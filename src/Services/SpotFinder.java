package Services;

import Model.Floor;
import Model.Spots.Spot;
import Model.VehicleType;
import Repository.FloorRepository;
import Exception.ParkingLotException;
import javafx.util.Pair;

import static Exception.ParkingLotExceptionType.NoSpotsAvailableException;

public class SpotFinder {
    private FloorRepository floorRepository;

    public SpotFinder() {
        this.floorRepository = FloorRepository.getInstance();
    }

    public Pair<Integer,Spot> getAvailableSpot(VehicleType vehicleType) throws ParkingLotException{
        for(var floor:floorRepository.getFloors()) {
            for(var spot:floor.getSpots()) {
                if (spot.getVehicleType() == vehicleType && spot.isAvailable()) {
                    return new Pair<>(floor.getFloorNumber(), spot);
                }
            }
        }
        throw new ParkingLotException("There are no spots available",NoSpotsAvailableException);
    }
}
