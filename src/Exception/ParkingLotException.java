package Exception;

public class ParkingLotException extends Exception{
    private ParkingLotExceptionType parkingLotExceptionType;

    public ParkingLotException(String message,ParkingLotExceptionType parkingLotExceptionType) {
        super(message);
        this.parkingLotExceptionType = parkingLotExceptionType;
    }

    public ParkingLotExceptionType getParkingLotExceptionType() {
        return parkingLotExceptionType;
    }
}
