package V7.ThreadPools.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newFixedThreadPool(4);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Runnable r = () -> {
            System.out.println("Hello" + Thread.currentThread());
        };
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);

        executorService1.execute(r);
        executorService1.execute(r);
        executorService1.execute(r);

        executorService.shutdown();
        executorService1.shutdown();
    }
}
