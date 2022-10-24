package hw4.readWriter.A2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lock {
    private boolean isLocked = false;
    private Thread lockingThread;

    private Queue<Thread> waitingThreads = new LinkedBlockingQueue<>();

    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
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

    public synchronized void lockInterruptibly() throws InterruptedException {
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

    public synchronized void unlock() {
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

