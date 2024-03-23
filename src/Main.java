import Exception.ParkingLotException;
import Model.*;
import Model.Spots.Spot;
import Services.BlockSpotService;
import Services.EntryGateService;
import Services.ExitGateService;
import Services.SpotFinder;
import javafx.util.Pair;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        try {
            SpotDriver spotDriver = new SpotDriver();
            spotDriver.run();
            Vehicle car = new Vehicle(VehicleType.Car);
            Vehicle truck = new Vehicle(VehicleType.Truck);
            SpotFinder spotFinder = new SpotFinder();
            Pair<Integer,Spot> availableSpotForCar = spotFinder.getAvailableSpot(car.getVehicleType());
            BlockSpotService blockSpotService = new BlockSpotService();
            blockSpotService.blockSpot(availableSpotForCar.getValue(),availableSpotForCar.getKey());
            EntryGateService entryGateService = new EntryGateService(car, LocalTime.now(),availableSpotForCar.getValue(),availableSpotForCar.getKey());
            Ticket ticket = entryGateService.generateTicket();
            ExitGateService exitGateService = new ExitGateService(ticket, PaymentMode.Cash);
            Payment payment = exitGateService.doPayment();
            System.out.println(exitGateService.freeParkingSpot(payment));



            Pair<Integer,Spot> availableSpotForTruck = spotFinder.getAvailableSpot(truck.getVehicleType());
            blockSpotService.blockSpot(availableSpotForTruck.getValue(),availableSpotForTruck.getKey());
            entryGateService = new EntryGateService(truck,LocalTime.now(),availableSpotForTruck.getValue(),availableSpotForTruck.getKey());
            ticket = entryGateService.generateTicket();
            exitGateService = new ExitGateService(ticket,PaymentMode.CreditCard);
            payment = exitGateService.doPayment();
            System.out.println(exitGateService.freeParkingSpot(payment));
        }catch(ParkingLotException ex) {
            System.out.println(ex.getMessage());
        }
    }
}