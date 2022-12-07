package allHomework.WE4;

import java.util.LinkedList;
import java.util.Queue;

// Nicht getestet, vom gefühl her müsste es aber funktionieren

public class ReentrantLock {

    private boolean isLocked = false;
    private Thread lockingThread;
    private int lockedTimes = 0;
    private Queue<Thread> waitingThreads = new LinkedList<>();

    public boolean isLocked() {
        return isLocked;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked && lockingThread != Thread.currentThread() || (!isLocked && (waitingThreads.peek() != Thread.currentThread()) && (waitingThreads.peek() != null))) {
            if (!waitingThreads.contains(Thread.currentThread())) {
                waitingThreads.add(Thread.currentThread());
            }
            wait();
        }
        lockedTimes++;
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockingThread) {
            throw new RuntimeException("Current thread not owner");
        }
        lockedTimes--;
        if (lockedTimes == 0) {
            isLocked = false;
            waitingThreads.poll();
            notifyAll();
        }
    }

    public synchronized boolean trylock() throws InterruptedException {
        if (isLocked && (lockingThread != Thread.currentThread())) {
            return false;
        } else {
            lock();
            return true;
        }
    }

    public synchronized void lockInterruptibly() {
        while (isLocked && (lockingThread != Thread.currentThread()) || (!isLocked && (waitingThreads.peek() != Thread.currentThread()) && (waitingThreads.peek() != null))) {
            if (!waitingThreads.contains(Thread.currentThread())) {
                waitingThreads.add(Thread.currentThread());
            }
        }
        try {
            wait();
        } catch (InterruptedException ignored) {
            waitingThreads.remove(Thread.currentThread());
            return;
        }
        lockedTimes++;
        isLocked = true;
        lockingThread = Thread.currentThread();
    }
}

