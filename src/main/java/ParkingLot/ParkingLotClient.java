package ParkingLot;

public class ParkingLotClient {

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        Vehicle truck = new Truck("abc");
        ParkingLevel level = new ParkingLevel(1, 6);
        parkingLot.addLevels(level);
        parkingLot.displayAvailability();
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(new Truck("def"));
        parkingLot.parkVehicle(new Truck("ghi"));
        parkingLot.displayAvailability();
        parkingLot.unParkVehicle(truck);
        System.out.println("After un parking ");
        parkingLot.displayAvailability();
    }
}
