
// Vehicle Interface
public interface Vehicle {
    // Method to retrieve the make of the vehicle
    String getMake();

    // Method to retrieve the model of the vehicle
    String getModel();

    // Method to retrieve the year of manufacture of the vehicle
    int getYearOfManufacture();
}

// CarVehicle Interface extends Vehicle
public interface CarVehicle extends Vehicle {
    // Method to set the number of doors in the car
    void setNumberOfDoors(int doors);

    // Method to get the number of doors in the car
    int getNumberOfDoors();

    // Method to set the fuel type of the car (Petrol, Diesel, Electric)
    void setFuelType(String fuelType);

    // Method to get the fuel type of the car
    String getFuelType();
}

// Car Class implements CarVehicle
public class Car implements CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;

    // Constructor for Car class
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }

    // Implementing methods from Vehicle and CarVehicle interfaces
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }
}

// MotorVehicle Interface extends Vehicle
public interface MotorVehicle extends Vehicle {
    // Method to set the number of wheels in the motorcycle
    void setNumberOfWheels(int wheels);

    // Method to get the number of wheels in the motorcycle
    int getNumberOfWheels();

    // Method to set the type of motorcycle (Sport, Cruiser, Off-road)
    void setMotorcycleType(String type);

    // Method to get the type of motorcycle
    String getMotorcycleType();
}

// Motorcycle Class implements MotorVehicle
public class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;

    // Constructor for Motorcycle class
    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }

    // Implementing methods from Vehicle and MotorVehicle interfaces
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        this.motorcycleType = type;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
}

// TruckVehicle Interface extends Vehicle
public interface TruckVehicle extends Vehicle {
    // Method to set the cargo capacity in tons
    void setCargoCapacity(double capacity);

    // Method to get the cargo capacity in tons
    double getCargoCapacity();

    // Method to set the transmission type (Manual, Automatic)
    void setTransmissionType(String transmissionType);

    // Method to get the transmission type
    String getTransmissionType();
}

// Truck Class implements TruckVehicle
public class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    // Constructor for Truck class
    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }

    // Implementing methods from Vehicle and TruckVehicle interfaces
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
}