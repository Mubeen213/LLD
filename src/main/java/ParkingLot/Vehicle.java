package ParkingLot;

public abstract class Vehicle {

    String numberPlate;
    VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType type) {
        this.numberPlate = numberPlate;
        this.vehicleType = type;
    }

    public VehicleType getType() {
        return vehicleType;
    }

    enum VehicleType {
        MOTORCYCLE,
        CAR,
        TRUCK
    }
}


class MotorCycle extends Vehicle {

    public MotorCycle(String numberPlate) {
        super(numberPlate, VehicleType.MOTORCYCLE);
    }
}

class Car extends Vehicle {

    public Car(String numberPlate) {
        super(numberPlate, VehicleType.CAR);
    }
}

class Truck extends Vehicle {

    public Truck(String numberPlate) {
        super(numberPlate, VehicleType.TRUCK);
    }
}
