package GettingStartetWithThreads;

public class HelloRunnable {

    public static void main(String[] args) {
       Thread t = new Thread(new MyRunnable());
       t.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}
