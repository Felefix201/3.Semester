package V7.ThreadPools.Callable;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> c = () -> {
            return "Hello";
        };

        Future<String> future = executorService.submit(c);
        System.out.println("future is done? " + future.isDone());
        System.out.println("future is done? " + future.isDone());   //Da ein Printline viel Prozessorzeit kostet, kommt das true verzögert
        System.out.println("restult: " + future.get());
        executorService.shutdown();
    }
}
