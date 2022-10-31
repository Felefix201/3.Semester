package allHomework.WE3.one;

import java.util.concurrent.Semaphore;

public class cookingWithSemaphore {
    Semaphore nudelnKochen = new Semaphore(1);
    Semaphore zwiebelnSchneiden = new Semaphore(1);
    Semaphore tomatenSchneiden = new Semaphore(1);
    Semaphore sosseKochen = new Semaphore(2);
    Semaphore servieren = new Semaphore(2);

    public static void main(String[] args) {
        //TODO Methode wie bei Pascal
    }


}
