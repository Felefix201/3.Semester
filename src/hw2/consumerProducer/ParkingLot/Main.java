package hw2.consumerProducer.ParkingLot;

public class Main {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(12, 12);

        for (int i = 0; i < 20; i++) {  // create 20 cars
            Car car = new Car(parkingLot, "Car " + i+1); // care nr. starts from 1
            car.start();
        }
    }

}
