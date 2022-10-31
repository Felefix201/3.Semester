package allHomework.WE2.one_two;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 20; i++) {
            Car car = new Car(parkingLot, "Car " + i);
            car.start();
        }
    }
}
