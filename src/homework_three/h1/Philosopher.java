package homework_three.h1;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true) {
            think();
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.take();
            rightFork.take();
            eat();
            System.out.println("Philosopher " + id + " is done eating");
            try{
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            leftFork.put();
            rightFork.put();
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking");
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is eating");
    }
}
