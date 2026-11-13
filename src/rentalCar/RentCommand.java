package rentalCar;

public class RentCommand implements Command {
    private final RentalAgency agency;
    private final String[] parts;

    public RentCommand(RentalAgency agency, String[] parts) {
        this.agency = agency;
        this.parts = parts;
    }

    @Override
    public void execute() throws VehicleNotAvailableException {
        String licensePlate = parts[1];
        int days = Integer.parseInt(parts[2]);

        double cost = agency.rentVehicle(licensePlate, days);
        System.out.printf("Rented %s for %d days - Total: $%.2f%n", licensePlate, days, cost);
    }
}
