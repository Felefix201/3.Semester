package hw2.consumerProducer.ParkingLot;

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
            throw new RuntimeException(e);
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parkingLot.leave();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " has been in the parking lot for " + (System.nanoTime() - time) / 1000 + " microseconds.");
    }
}

