package hw3.semaphore;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(2);
        int seats = table.getSize();
        Philosopher[] philosophers = new Philosopher[seats];
        Fork[] forks = new Fork[seats];
        for (int i = 0; i < seats; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < seats; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % table.getSize()]);
            System.out.println(forks[i].hashCode() + " " + forks[(i + 1) % table.getSize()].hashCode() + " have been taken by " + philosophers[i].hashCode());
        }
        for (int i = 0; i < seats; i++) {
            philosophers[i].start();
        }
    }
}
