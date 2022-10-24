package V1.gettingStartetWithThreads;

public class NudelnKochen {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            nudelnKochen();
        };
        Thread t1 = new Thread(r1);

       // Thread t2 = new Thread(NudelnKochen::sosseKochen);   Nur Wenn die Methode sosseKochen keine Parameter mitgegeben bekommt
        Thread t2 = new Thread(() -> sosseKochen(5));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);}


        servieren();
    }

    public static void nudelnKochen(){
        System.out.println("Nudeln kochen");
    }

    public static void sosseKochen(int dauer){
        System.out.println("Soße kochen");
    }

    public static void servieren(){
        System.out.println("Servieren");
    }

    public static void execute(Runnable... runnables){
        for (Runnable r : runnables){
            Thread t = new Thread(r);
            t.start();
        }
    }

}
