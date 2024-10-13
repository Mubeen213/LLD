package ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {


    Map<Integer,ParkingLevel> parkingLevels;

    private ParkingLot() {
        this.parkingLevels = new HashMap<>();
    }

    private static final class InstanceHolder {
        private static final ParkingLot instance = new ParkingLot();
    }

    public static ParkingLot getInstance() {
        return InstanceHolder.instance;
    }

    public void addLevel(ParkingLevel level) {
        parkingLevels.put(parkingLevels.size() + 1, level);
    }

    public int parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels.values()) {
            return level.parkVehicle(vehicle);
        }
        return -1;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels.values()) {
            return level.unParkVehicle(vehicle);
        }
        return false;
    }

    public void displayEmptySpots() {
       for(ParkingLevel level: parkingLevels.values()) {
           level.displayAvailableSpots();
       }
    }

    public int getFreeSpotsAtGivenLevel(int level) {
        ParkingLevel parkingLevel = parkingLevels.get(level);
        if(Objects.isNull(parkingLevel)) {
            System.out.println("Level does not exist");
        }
        return parkingLevel.getNumberOfFreeSpots();
    }
}
