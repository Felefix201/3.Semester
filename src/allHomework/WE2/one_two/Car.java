package allHomework.WE2.one_two;


public class Car extends Thread {

    private ParkingLot parkingLot;

    public Car(ParkingLot parkingLot, String name) {
        super(name);
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        long time = System.nanoTime();

        try {
            parkingLot.enter(this);
        } catch (InterruptedException e) {
            System.out.println("An Error while entering has occured");
        }

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("An Error while Thread sleeping has occured");
        }

        parkingLot.leave();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("An Error while Thread sleeping has occured");
        }

        System.out.println(this.getName() + " has been in the parking lot for " + (System.nanoTime() - time) / 1000 + " microseconds.");
    }
}
