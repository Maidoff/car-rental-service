package rentalCar;

public class AvailableCommand implements Command {
    private final RentalAgency agency;
    private final String[] parts;

    public AvailableCommand(RentalAgency agency, String[] parts) {
        this.agency = agency;
        this.parts = parts;
    }

    @Override
    public void execute() {
        System.out.println("Available vehicles:");
        for (Vehicle vehicle : agency.getAvailableVehicles()) {
            System.out.println(vehicle.getDetails());
        }
    }
}
