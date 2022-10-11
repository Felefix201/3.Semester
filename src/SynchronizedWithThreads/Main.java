package SynchronizedWithThreads;

public class Main {

    public static void main(String[] args) {

        ParkingSlot parkingSlot = new ParkingSlot(10);

        new Car(parkingSlot).start();   // kurzschreibweise bei der der Name nicht unterschiedlich sein muss
        new Car(parkingSlot).start();   // kurzschreibweise
        new Car(parkingSlot).start();   // kurzschreibweise
        new Car(parkingSlot).start();   // kurzschreibweise

        Car c2 = new Car(parkingSlot);  // langschreibweise
        c2.start();

    }

}
