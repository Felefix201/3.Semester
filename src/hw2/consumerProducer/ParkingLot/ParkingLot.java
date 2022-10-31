package hw2.consumerProducer.ParkingLot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ParkingLot {
    private int availablePlaces;
 //   private static int nextQueueNumber = 0;
 //   private static int nextQueueMemberToEnter = 0;
 //   private static int nextQueueMemberToLeave = 0;

    private static int maxPlaces;
    private static BlockingQueue<Car> queue = new LinkedBlockingDeque<>(maxPlaces);
    public ParkingLot(int places, int maxPlaces) {
        this.availablePlaces = places;
        ParkingLot.maxPlaces = maxPlaces;
    }

    public synchronized void enter(Car auto) throws InterruptedException {
        queue.add(auto);
        while (availablePlaces == 0) {
            wait();
        }
        availablePlaces--;
        queue.take();
        System.out.println(Thread.currentThread().getName() + " has entered the parking lot. Available places: " + availablePlaces);
    }

    public synchronized void leave() {
        notifyAll();
        availablePlaces++;
        System.out.println(Thread.currentThread().getName() + " has left the parking lot. Available places = " + availablePlaces);;
    }

    /**
    public synchronized void enter() {
        int queueNumber = nextQueueNumber++;
        System.out.println("Car " + queueNumber + " is waiting to enter the parking lot.");
        System.out.println("There are " + availablePlaces + " places available.");
        while (availablePlaces == 0 || queueNumber == nextQueueMemberToEnter) {
            try {
                wait();
                nextQueueMemberToLeave = queueNumber;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availablePlaces--;
        nextQueueMemberToEnter++;
        System.out.println(Thread.currentThread().getName() + " has entered the parking lot. Available places: " + availablePlaces);
    }

    public synchronized void leave() {
        notifyAll();
        availablePlaces++;
        System.out.println(Thread.currentThread().getName() + " has left the parking lot. Available places = " + availablePlaces);;
    }
    */
}