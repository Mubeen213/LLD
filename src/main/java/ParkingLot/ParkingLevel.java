package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private List<ParkingSpot> parkingSpots;

    public ParkingLevel(int numOfSpots) {
        parkingSpots = new ArrayList<>(numOfSpots);

        double bikes = 0.5;
        double cars = 0.3;

        int numOfBikes = (int) (bikes * numOfSpots);
        int numOfCars = (int) (cars * numOfSpots);

        for (int i = 1; i <= numOfBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }

        for (int i = numOfBikes + 1; i <= numOfCars + numOfBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = numOfCars + numOfBikes + 1; i <= numOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public int parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            int spotNumber = spot.park(vehicle);
            if (spotNumber != -1) {
                return spotNumber;
            }
        }
        return -1;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.release(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailableSpots() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isSpotFree()) {
                System.out.println("Spot is free at " + spot.getSpotNumber() + " for vehicle "
                    + spot.getVehicleType());
            }
        }
    }

    public int getNumberOfFreeSpots() {
        int freeSpots = 0;
        for(ParkingSpot spot: parkingSpots) {
            if(spot.isSpotFree()) {
                freeSpots++;
            }
        }
        return freeSpots;
    }
}
