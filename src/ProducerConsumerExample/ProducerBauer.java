package ProducerConsumerExample;

public class ProducerBauer extends Thread {
    private LagerBuffer lagerBuffer;
    private boolean terminate = false;

    public ProducerBauer(LagerBuffer lagerBuffer) {
        this.lagerBuffer = lagerBuffer;
    }

    void terminate() {
        terminate = true;
    }

    @Override
    public void run() {
        while (!terminate) {
            int randomInt = (int) (Math.random() * 10);
            String value = "";
            if (randomInt > 3 && randomInt < 6) {
                value = "Kartoffeln";
            } else if (randomInt > 3) {
                value = "Mais";
            } else {
                value = "Roggen";
            }
            lagerBuffer.put(value);
        }
        System.out.println("Producer terminated");
    }
}
