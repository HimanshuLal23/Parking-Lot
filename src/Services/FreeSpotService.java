package Services;

import Model.Spots.Spot;
import Repository.FloorRepository;

public class FreeSpotService {
    private FloorRepository floorRepository;

    public FreeSpotService() {
        this.floorRepository = FloorRepository.getInstance();
    }

    public void freeSpot(Spot spot,int floorNumber) {
        for(var floor:floorRepository.getFloors()) {
            if(floor.getFloorNumber() == floorNumber) {
                for(var currentspot:floor.getSpots()) {
                    if(currentspot.equals(spot)) {
                        currentspot.setAvailable();
                    }
                }
            }
        }
    }
}
