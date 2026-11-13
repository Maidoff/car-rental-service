package rentalCar;

public class ReturnCommand implements Command {
    private final RentalAgency agency;
    private final String[] parts;

    public ReturnCommand(RentalAgency agency, String[] parts) {
        this.agency = agency;
        this.parts = parts;
    }

    @Override
    public void execute() {
        String licensePlate = parts[1];

        if (agency.returnVehicle(licensePlate)) {
            System.out.println("Returned: " + licensePlate);
        } else {
            System.out.println("Return failed: " + licensePlate);
        }
    }
}
