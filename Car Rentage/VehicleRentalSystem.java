
// Main Program
import java.util.Scanner;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Rental System!");

        // Ask the user to enter the type of vehicle
        System.out.println("Enter vehicle type (Car, Motorcycle, Truck): ");
        String vehicleType = scanner.nextLine();

        Vehicle vehicle = null;

        // Create a specific type of vehicle based on user input
        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicle = createCar(scanner);
                break;
            case "motorcycle":
                vehicle = createMotorcycle(scanner);
                break;
            case "truck":
                vehicle = createTruck(scanner);
                break;
            default:
                System.out.println("Invalid vehicle type entered.");
                return;
        }

        // Display the details of the created vehicle
        displayVehicleDetails(vehicle);
        scanner.close(); // Close the scanner to prevent resource leaks
    }

    private static Car createCar(Scanner scanner) {
        // Gather car details from the user
        System.out.println("Enter Car Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Car Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter Year of Manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Car car = new Car(make, model, year);

        System.out.println("Enter Number of Doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        car.setNumberOfDoors(doors);

        System.out.println("Enter Fuel Type (Petrol, Diesel, Electric): ");
        String fuelType = scanner.nextLine();
        car.setFuelType(fuelType);

        return car;
    }

    private static Motorcycle createMotorcycle(Scanner scanner) {
        // Gather motorcycle details from the user
        System.out.println("Enter Motorcycle Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Motorcycle Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter Year of Manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Motorcycle motorcycle = new Motorcycle(make, model, year);

        System.out.println("Enter Number of Wheels: ");
        int wheels = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        motorcycle.setNumberOfWheels(wheels);

        System.out.println("Enter Motorcycle Type (Sport, Cruiser, Off-road): ");
        String type = scanner.nextLine();
        motorcycle.setMotorcycleType(type);

        return motorcycle;
    }

    private static Truck createTruck(Scanner scanner) {
        // Gather truck details from the user
        System.out.println("Enter Truck Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Truck Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter Year of Manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Truck truck = new Truck(make, model, year);

        System.out.println("Enter Cargo Capacity (in tons): ");
        double capacity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        truck.setCargoCapacity(capacity);

        System.out.println("Enter Transmission Type (Manual, Automatic): ");
        String transmissionType = scanner.nextLine();
        truck.setTransmissionType(transmissionType);

        return truck;
    }

    private static void displayVehicleDetails(Vehicle vehicle) {
        // Display common vehicle details
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year of Manufacture: " + vehicle.getYearOfManufacture());

        // Display specific details based on the type of vehicle
        if (vehicle instanceof CarVehicle) {
            CarVehicle car = (CarVehicle) vehicle;
            System.out.println("Number of Doors: " + car.getNumberOfDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } else if (vehicle instanceof MotorVehicle) {
            MotorVehicle motorcycle = (MotorVehicle) vehicle;
            System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
            System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
        } else if (vehicle instanceof TruckVehicle) {
            TruckVehicle truck = (TruckVehicle) vehicle;
            System.out.println("Cargo Capacity (in tons): " + truck.getCargoCapacity());
            System.out.println("Transmission Type: " + truck.getTransmissionType());
        }
    }
}
