package rentalCar;

public class AddVehicleCommand implements Command {
    private final RentalAgency agency;
    private final String[] parts;

    public AddVehicleCommand(RentalAgency agency, String[] parts) {
        this.agency = agency;
        this.parts = parts;
    }

    @Override
    public void execute() {
        Vehicle vehicle = VehicleFactory.createVehicle(parts);
        agency.addVehicle(vehicle);
        System.out.println("Added: " + vehicle.getBrand() + " (" + vehicle.getVehicleType() + ")");
    }
}
