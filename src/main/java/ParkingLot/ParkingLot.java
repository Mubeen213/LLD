package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static volatile ParkingLot instance;
    private List<ParkingLevel> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {

        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addLevels(ParkingLevel level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            level.unParkVehicle(vehicle);
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingLevel level : levels) {
            level.displayAvailableSpots();
        }
    }
}
