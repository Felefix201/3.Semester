package GettingStartetWithThreads;

public class HelloWorldThread extends Thread{

    public static void main(String[] args) {
        Thread t = new HelloWorldThread();
        t.start();
        // t.run();
    }

    @Override
    public void run() {
        System.out.println("Hello");
    }
}
