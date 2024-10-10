package ParkingLot;

import ParkingLot.Vehicle.VehicleType;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingLevel {

    private static final Logger log = LoggerFactory.getLogger(ParkingLevel.class);
    private Integer floor;
    List<ParkingSpot> spots;

    public ParkingLevel(Integer floor, Integer numberOfSpots) {
        this.floor = floor;
        this.spots = new ArrayList<>(numberOfSpots);
        // Assign spots in ratio of 50:40:10 for bikes, cars and trucks
        double bikes = 0.50;
        double cars = 0.40;

        int numBikes = (int) (numberOfSpots * bikes);
        int numCars = (int) (numberOfSpots * cars);
        int numTrucks = (numberOfSpots - numBikes - numCars);

        for(int i=1; i<= numBikes; i++) {
            spots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }
        for(int i=numBikes+1; i<= numBikes + numCars; i++) {
            spots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i=numBikes+numCars+1; i<= numberOfSpots; i++) {
            spots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getVehicleType().equals(vehicle.getType())) {
               boolean isParked =  spot.park(vehicle);
               if(!isParked) {
                   System.out.println("Vehicle not parked " + vehicle.toString());
                   return false;
               }
                System.out.println("Vehicle parked");
               return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.release();
                return true;
            }
        }
        return false;
    }

    public void displayAvailableSpots() {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                System.out.println(
                    "Spot " + spot.getSpotNumber() + " is available at level  " + this.floor + " for vehicle type "
                        + spot.getVehicleType());
            }
        }
    }
}
