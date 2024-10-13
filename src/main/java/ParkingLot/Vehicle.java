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

}


class Bike extends Vehicle {

    public Bike(String numberPlate) {
        super(numberPlate, VehicleType.BIKE);
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
