package Repository;

import Model.Floor;
import Model.Spots.Spot;

import java.util.ArrayList;
import java.util.List;

public class SpotRepository {
    private static List<Spot> spots;
    private SpotRepository() {
        spots = new ArrayList<>();
    }
    private static class Holder {
        public static SpotRepository instance = new SpotRepository();
    }
    public static SpotRepository getInstance() {
        return SpotRepository.Holder.instance;
    }
    public static void addSpot(Spot spot) {
        spots.add(spot);
    }
    public static List<Spot> getSpots() {
        return spots;
    }
}
