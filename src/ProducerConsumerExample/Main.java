package ProducerConsumerExample;

public class Main {

    public static void main(String[] args) {
        BufferRewe bufferRewe = new BufferRewe(10);
        BufferAldi bufferAldi = new BufferAldi(15);

        ProducerFarmer producerFarmer = new ProducerFarmer(bufferRewe, bufferAldi);
        ProducerFarmer producerFarmer2 = new ProducerFarmer(bufferRewe, bufferAldi);

        ProducerImker producerImker = new ProducerImker(bufferRewe, bufferAldi);

        ConsumerCusomer consumerCusomer = new ConsumerCusomer(bufferRewe, bufferAldi);
        ConsumerCusomer consumerCusomer2 = new ConsumerCusomer(bufferRewe, bufferAldi);
        ConsumerCusomer consumerCusomer3 = new ConsumerCusomer(bufferRewe, bufferAldi);

        producerFarmer.start();
        producerFarmer2.start();
        producerImker.start();
        consumerCusomer.start();
        consumerCusomer2.start();
        consumerCusomer3.start();

    }

}
