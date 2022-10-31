package allHomework.WE1.one;

public class executeCountingThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("t1 counting " + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("t2 counting " + i);
            }
        });

        //t1.start();
        //t2.start();

        executeCountingThreads(5, 2);

    }

    private static void executeCountingThreads(int numberOfThreads, int max){
        for (int i = 0; i < numberOfThreads; i++) {
            final int finalI = i;
            Thread t = new Thread(() -> {
                for (int j = 0; j < max; j ++){
                    System.out.println("t" + finalI + " counting " + j);
                }
            });
            t.start();
        }
    }

}


