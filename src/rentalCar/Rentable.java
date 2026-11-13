package rentalCar;

public interface Rentable {
    boolean rent();

    boolean returnVehicle();

    double calculateCost(int days);
}
