package SynchronizedWithThreads;

public class Car extends Thread {
    private ParkingSlot parkingSlot;

    public Car(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            parkingSlot.enter();
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            parkingSlot.leave();
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}

