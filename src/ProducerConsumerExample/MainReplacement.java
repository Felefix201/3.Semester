package ProducerConsumerExample;

public class MainReplacement {
    public static void main(String[] args) {
        LagerBuffer lagerBuffer = new LagerBuffer(20);
        ProducerBauer producerBauer = new ProducerBauer(lagerBuffer);
        Consumer consumer = new Consumer(lagerBuffer, 10, "Rewe");
        Consumer consumer2 = new Consumer(lagerBuffer, 10, "Aldi");

        producerBauer.start();
        consumer.start();
        consumer2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerBauer.terminate();
        consumer.terminate();
        consumer2.terminate();
    }
}
