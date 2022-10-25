package hw4.readWriter.A2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lock { //TODO Adham, mach das hier mal richtig so wie in der A Übung besprochen
    private boolean isLocked = false;
    private Thread lockingThread;

    private Queue<Thread> waitingThreads = new LinkedBlockingQueue<>();

    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException {   //TODO Anpassen von Adham
        if (lockingThread != Thread.currentThread()) {
            waitingThreads.add(Thread.currentThread());
            while (isLocked || lockingThread != Thread.currentThread()) {
                wait();
            }
        }
        lockCount++;
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void lockInterruptibly() throws InterruptedException {      //TODO vielleicht anpassen???
        if (lockingThread != Thread.currentThread()) {
            waitingThreads.add(Thread.currentThread());
            while (isLocked && lockingThread != Thread.currentThread()) {
                wait();
            }
        }
        lockCount++;
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {     //TODO Anpassen von Adham
        if (Thread.currentThread() != lockingThread) {
            throw new IllegalLockStateException("Current thread not owner");
        }
        lockCount--;
        if (lockCount == 0) {
            this.lockingThread = waitingThreads.poll();
            isLocked = false;
            notify();
        }
    }


    public static class IllegalLockStateException extends RuntimeException {
        public IllegalLockStateException(String message) {
            super(message);
        }
    }
}

