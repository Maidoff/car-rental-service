package rentalCar;

public interface Command {
    void execute() throws VehicleNotAvailableException;
}
