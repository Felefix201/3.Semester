package allHomework.WE2.one_one;

public class ParkingLot {

    private int availablePlaces;
    private static int maxPlaces;

    public ParkingLot(int maxPlaces) {
        ParkingLot.maxPlaces = maxPlaces;
        availablePlaces = maxPlaces;
    }

    public synchronized void enter(Car car) throws InterruptedException {
        while (availablePlaces == 0) {
                wait();
        }
        availablePlaces -= 1;
        System.out.println(car.getName() + " entered the parking lot. " + availablePlaces + " places left.");
    }

    public synchronized void leave() {
        availablePlaces += 1;
        notifyAll();
        System.out.println("A car left the parking lot. " + availablePlaces + " places left.");
    }
}
