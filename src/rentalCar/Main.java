package rentalCar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        RentalAgency rentalAgency = new RentalAgency();
        String[] command = input.split(",");

        Map<String, BiFunction<RentalAgency, String[], Command>> commandRegistry = new HashMap<>();

        for (String cmd : command) {
            String[] parts = cmd.split(":");
            String operation = parts[0];

            commandRegistry.put("ADD_CAR", AddVehicleCommand::new);
            commandRegistry.put("ADD_MOTORCYCLE", AddVehicleCommand::new);

            commandRegistry.put("RENT", RentCommand::new);
            commandRegistry.put("RETURN", ReturnCommand::new);
            commandRegistry.put("AVAILABLE", AvailableCommand::new);

            if (commandRegistry.containsKey(operation)) {
                try {
                    commandRegistry.get(operation)
                            .apply(rentalAgency, parts)
                            .execute();
                } catch (VehicleNotAvailableException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command: " + operation);
            }
        }

        System.out.println("--- Fleet Summary ---");
        for (Vehicle vehicle : rentalAgency.getAllVehicles()) {
            System.out.println(vehicle.getDetails());
        }
    }
}