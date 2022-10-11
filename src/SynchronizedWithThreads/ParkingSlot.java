package SynchronizedWithThreads;

public class ParkingSlot {
    private int availableSlots;

    public ParkingSlot(int places){
        this.availableSlots = places;
    }

    public synchronized void enter() {
       // while (!tryToEnter());  // busy waiting = nicht verwenden
        while (availableSlots == 0) {
            try {
                wait();                                             // Gibt Monitor zurück während Wartezimmer, danach bekommt man es wieder
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        availableSlots--;
        System.out.println("Car entered. Available slots: " + availableSlots);
    }

    public synchronized void leave(){
        availableSlots++;
        System.out.println("Car left. Available slots: " + availableSlots);
        notify();                                                  // Weckt einen wartenden Thread auf
    }

    private synchronized boolean tryToEnter(){
        if (availableSlots > 0){
            availableSlots--;
            System.out.println("Car entered. Available slots: " + availableSlots);
            return true;
        }
        return false;
    }



}
