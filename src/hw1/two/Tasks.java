package hw1.two;

import java.util.ArrayList;
import java.util.List;


/**
 * Homework Nr. 1.2
 */
public class Tasks {

    static Runnable nudelnKochen = () -> {
        System.out.println("Nudeln kochen");
    };

    static Runnable zwiebelnSchneiden = () -> {
        System.out.println("Zwiebeln schneiden");
    };

    static Runnable tomatenSchneiden = () -> {
        System.out.println("Tomaten schneiden");
    };

    static Runnable sauceKochen = () -> {
        executeBlocking(tomatenSchneiden, zwiebelnSchneiden);
        System.out.println("Sauce kochen");
    };

    static Runnable servieren = () -> {
        executeBlocking(nudelnKochen, sauceKochen);
        System.out.println("Servieren");
    };

    public static void main(String[] args) {
        executeBlocking(servieren);

        //Alternativ
        //executeBlocking(Main::zwiebelnSchneiden, Main::tomatenSchneiden, Main::nudelnKochen, Main::sauceKochen, Main::servieren);
    }

    static void executeBlocking(Runnable... runnables) {
        List<Thread> threadList = new ArrayList<>();
        for (Runnable runnable : runnables) {
            Thread t = new Thread(runnable);
            threadList.add(t);
            t.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    static void executeBlocking(Runnable... runnables) throws InterruptedException {
//        List<Thread> threadList = new ArrayList<>();
//        for (Runnable runnable : runnables) {
//            Thread t = new Thread(runnable);
//            threadList.add(t);
//            t.start();
//        }
//        for (Thread thread : threadList) {
//                thread.join();
//        }
//    }



}
