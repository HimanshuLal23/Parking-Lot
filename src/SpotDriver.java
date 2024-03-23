import Factory.FloorFactory;
import Model.Floor;
import Model.Spots.CarSpot;
import Model.Spots.Spot;
import Repository.FloorRepository;
import Repository.SpotRepository;

import Exception.ParkingLotException;

public class SpotDriver {
    private SpotRepository spotRepository;
    private FloorRepository floorRepository;
    public SpotDriver() {
        this.spotRepository = SpotRepository.getInstance();
        this.floorRepository = FloorRepository.getInstance();
    }

    public void run() throws ParkingLotException{
        for(int floorNumber = 1;floorNumber<5;floorNumber++) {
            Floor floor = FloorFactory.createFloor(10,floorNumber);
            for(int i=0;i<10;i++) {
                Spot spot = new CarSpot();
                floor.addSpot(spot);
                spotRepository.addSpot(spot);
            }
            floorRepository.addFloor(floor);
        }
    }
}
