package hw5.countDownLatch;

import hw5.CyclicBarrier.CyclicBarrier;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch();
        countDownLatch.setInitial(3);
        countDownLatch.setCount();

        Runnable rCyclic = () -> {
            try {
            Random random = new Random();
            System.out.println(Thread.currentThread() + " starting.");
            Thread.sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread() + " 1st sync point. How many are missing: " + (countDownLatch.getParties() - countDownLatch.getNumberWaiting()));
            countDownLatch.await();
            System.out.println(Thread.currentThread() + " SYNCED");
        } catch (Exception e) {
        }};

        new Thread(rCyclic).start();
        new Thread(rCyclic).start();
        new Thread(rCyclic).start();
    }
}