package Services;

import Model.Spots.Spot;
import Repository.FloorRepository;
import Exception.*;

import static Exception.ParkingLotExceptionType.NoSpotsAvailableException;

public class BlockSpotService {
    private FloorRepository floorRepository;

    public BlockSpotService() {
        this.floorRepository = FloorRepository.getInstance();
    }

    public Spot blockSpot(Spot spot, int floorNumber) throws ParkingLotException {
        for(var floor:floorRepository.getFloors()) {
            if(floor.getFloorNumber() == floorNumber) {
                for(var currSpot:floor.getSpots()) {
                    if(currSpot.equals(spot)) {
                        spot.setUnavailable();
                        return spot;
                    }
                }
            }
        }
        throw new ParkingLotException("No spots available",NoSpotsAvailableException);
    }
}
