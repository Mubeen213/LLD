package ParkingLot;

public class ParkingLotClient {

    public static void main(String[] args) {
        Vehicle car = new Car("123");
        Vehicle bike = new Bike("321");
        Vehicle truck = new Truck("456");

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new ParkingLevel(5));
        parkingLot.addLevel(new ParkingLevel(5));

        int freeSpotsAtGivenLevel = parkingLot.getFreeSpotsAtGivenLevel(1);
        System.out.println(freeSpotsAtGivenLevel);
        int spotNumber = parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(truck);

        freeSpotsAtGivenLevel = parkingLot.getFreeSpotsAtGivenLevel(1);
        System.out.println( "Free spots at level 1 " + freeSpotsAtGivenLevel);

        parkingLot.unParkVehicle(car);

        freeSpotsAtGivenLevel = parkingLot.getFreeSpotsAtGivenLevel(1);
        System.out.println( "Free spots at level 1 " + freeSpotsAtGivenLevel);

        freeSpotsAtGivenLevel = parkingLot.getFreeSpotsAtGivenLevel(2);
        System.out.println( "Free spots at level 2 " + freeSpotsAtGivenLevel);
    }
}
