package hw5.CyclicBarrier;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier();
        cyclicBarrier.setInitial(3);
        cyclicBarrier.setCount();
        Runnable rCyclic = () -> { try {
            Random random = new Random();
            System.out.println(Thread.currentThread() + " starting.");
            Thread.sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread() + " 1st sync point. How many are missing: " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting()));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread() + " SYNCED");
            Thread.sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread() + " 2nd sync point. How many are missing: " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting()));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread() + " SYNCED again and done.");
        } catch (Exception e) {
        }};
        new Thread(rCyclic).start();
        new Thread(rCyclic).start();
        new Thread(rCyclic).start();
    }
}