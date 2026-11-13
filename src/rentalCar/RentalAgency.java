package rentalCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalAgency {
    private final List<Vehicle> vehicles;

    public RentalAgency() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findVehicle(String licensePlate) {
        return vehicles.stream()
                .filter(findVeh -> findVeh.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
    }

    public double rentVehicle(String licensePlate, int days) throws VehicleNotAvailableException {
        Vehicle vehicle = findVehicle(licensePlate);
        if (vehicle == null) {
            throw new VehicleNotAvailableException(licensePlate);
        }
        if (vehicle instanceof Rentable rentable) {
            if (rentable.rent()) return rentable.calculateCost(days);
        }
        throw new VehicleNotAvailableException(licensePlate);
    }

    public boolean returnVehicle(String licensePlate) {
        Vehicle vehicle = findVehicle(licensePlate);
        if (vehicle == null) {
            return false;
        }
        if (vehicle instanceof Rentable rentable) {
            return rentable.returnVehicle();
        }
        return false;
    }

    public List<Vehicle> getAllVehicles() {
        return List.copyOf(this.vehicles);
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(findAvailable -> findAvailable.getStatus() == RentalStatus.AVAILABLE)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}