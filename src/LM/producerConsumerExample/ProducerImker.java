package LM.producerConsumerExample;

import java.util.ArrayList;
import java.util.Random;

public class ProducerImker extends Thread {

    private final BufferRewe bufferRewe;

    private final BufferAldi bufferAldi;

    private boolean isStillProducer = true;
    private final ArrayList<String> honeyList = new ArrayList<>(20);
    private int currentHoneyListSize = 0;

    public ProducerImker(BufferRewe bufferRewe, BufferAldi bufferAldi) {
        this.bufferRewe = bufferRewe;
        this.bufferAldi = bufferAldi;
    }


    @Override
    public void run() {
        Random random = new Random(10);
        int randomInt1 = random.nextInt();
        int randomInt2 = random.nextInt();

        if (honeyList.size() < 20) {
            if (randomInt2 < 6) {
                if (randomInt1 < 3) {
                    honeyList.add("JummyHoney");
                    currentHoneyListSize++;
                } else if (randomInt1 < 6) {
                    honeyList.add("HoneyFromTheHive");
                    currentHoneyListSize++;
                } else {
                    honeyList.add("HoneyInAJar");
                    currentHoneyListSize++;
                }
            }
        }

        if (randomInt1 < 5) {
            while (isStillProducer) {
                if (currentHoneyListSize > 0) {
                    try {
                        bufferAldi.put(honeyList.remove(currentHoneyListSize));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Producer Imker for Aldi is exploded and can not be used anymore");
        } else {
            while (isStillProducer) {
                if (currentHoneyListSize > 0) {
                    try {
                        bufferRewe.put(honeyList.remove(currentHoneyListSize));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Producer Imker for Rewe is exploded and can not be used anymore");
        }
    }

    public void isStillProducer(boolean isStillProducer) {
        this.isStillProducer = isStillProducer;
    }


}
