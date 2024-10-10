package ParkingLot;


import ParkingLot.Vehicle.VehicleType;

public class ParkingSpot {

    private Integer spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(Integer spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        parkedVehicle = null;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public synchronized Boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (!isAvailable()) {
            System.out.println("Spot is not available");
            return false;
        }
        if (!vehicle.getType().equals(vehicleType)) {
            System.out.println("Spot not available for  vehicle type " + vehicle.getType());
            return false;
        }
        this.parkedVehicle = vehicle;
        return true;
    }

    public synchronized void release() {
        this.parkedVehicle = null;
    }

}
