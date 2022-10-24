package V1.gettingStartetWithThreads;

public class HelloRunnableLambda {
    public static void main(String[] args) {

        //    Thread t = new Thread(() -> {
        //        System.out.println("Hello!");
        //    });

        //    t.start();

        Runnable r = () -> {
            System.out.println("Hello");
            System.out.println("1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("2");
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        System.out.println("Done");
    }

}
