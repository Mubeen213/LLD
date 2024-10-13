package ParkingLot;


public class ParkingSpot {

    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isSpotFree() {
        return parkedVehicle == null;
    }

    public synchronized int park(Vehicle vehicle) {
        if (!vehicle.getType().equals(vehicleType)) {
            return -1;
        }
        if (!isSpotFree()) {
            return -1;
        }
        this.parkedVehicle = vehicle;
        return this.spotNumber;
    }

    public synchronized boolean release(Vehicle vehicle) {
        if (vehicle.equals(this.parkedVehicle)) {
            this.parkedVehicle = null;
            return true;
        }
        return false;
    }


}
