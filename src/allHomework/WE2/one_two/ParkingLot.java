package allHomework.WE2.one_two;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingLot {

    private int availablePlaces;
    private static int maxPlaces;
    private BlockingQueue<Car> cars;

    public ParkingLot(int maxPlaces) {
        ParkingLot.maxPlaces = maxPlaces;
        availablePlaces = maxPlaces;
        cars = new LinkedBlockingQueue<>(maxPlaces);
    }

    public synchronized void enter(Car car) throws InterruptedException {
        cars.add(car);
        while (availablePlaces == 0) {
                wait();
        }
        availablePlaces -= 1;
        cars.take();
        System.out.println(car.getName() + " entered the parking lot. " + availablePlaces + " places left.");
    }

    public synchronized void leave() {
        availablePlaces += 1;
        notifyAll();
        System.out.println("A car left the parking lot. " + availablePlaces + " places left.");
    }
}
