package allHomework.WE1.two;

public class cooking {

    public static void main(String[] args) {
        executeBlocking(servieren);
    }

    static Runnable nudelnKochen = () -> {
        System.out.println("Nudeln werden gekocht");
    };
    static Runnable zwiebelnSchneiden = () -> {
        System.out.println("Zwiebeln werden geschnitten");
    };
    static Runnable tomatenSchneiden = () -> {
        System.out.println("Tomaten werden geschnitten");
    };
    static Runnable sosseKochen = () -> {
        executeBlocking(zwiebelnSchneiden, tomatenSchneiden);
        System.out.println("Sosse wird gekocht");
    };
    static Runnable servieren = () -> {
        executeBlocking(nudelnKochen, sosseKochen);
        System.out.println("Gericht wird serviert");
    };

    private static void executeBlocking(Runnable... runnables) {
        for (Runnable runnable : runnables) {
            Thread t = new Thread(runnable);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
