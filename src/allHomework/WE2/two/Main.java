package allHomework.WE2.two;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(3);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.interrupt();
        consumer.interrupt();
    }

}
