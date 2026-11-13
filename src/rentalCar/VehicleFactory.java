package rentalCar;

public class VehicleFactory {
    public static Vehicle createVehicle(String[] parts) {
        String action = parts[0];
        return switch (action) {
            case "ADD_CAR" -> {
                String licensePlate = parts[1];
                String brand = parts[2];
                double dailyRate = Double.parseDouble(parts[3]);
                int seats = Integer.parseInt(parts[4]);

                yield new Car(licensePlate, brand, dailyRate, seats);
            }
            case "ADD_MOTORCYCLE" -> {
                String licensePlate = parts[1];
                String brand = parts[2];
                double dailyRate = Double.parseDouble(parts[3]);
                int engineCC = Integer.parseInt(parts[4]);

                yield new Motorcycle(licensePlate, brand, dailyRate, engineCC);
            }
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
    }
}
