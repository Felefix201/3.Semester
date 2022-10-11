package ProducerConsumerExample;

import java.util.ArrayList;
import java.util.Random;

public class ProducerFarmer extends Thread {

    private final BufferRewe bufferRewe;

    private final BufferAldi bufferAldi;

    private boolean isStillProducer = true;
    private final ArrayList<String> plantList = new ArrayList<>(20);
    private int currentPlantListSize = 0;

    public ProducerFarmer(BufferRewe bufferRewe, BufferAldi bufferAldi) {
        this.bufferRewe = bufferRewe;
        this.bufferAldi = bufferAldi;
    }


    @Override
    public void run() {
        Random random = new Random(10);
        int randomInt1 = random.nextInt();
        int randomInt2 = random.nextInt();

        if (plantList.size() < 20) {
            if (randomInt2 < 6) {
                if (randomInt1 < 3) {
                    plantList.add("Mais");
                    currentPlantListSize++;
                } else if (randomInt1 < 6) {
                    plantList.add("Roggen");
                    currentPlantListSize++;
                } else {
                    plantList.add("Kartoffeln");
                    currentPlantListSize++;
                }
            }
        }

        if (randomInt1 < 5) {
            while (isStillProducer) {
                if (currentPlantListSize > 0) {
                    try {
                        bufferAldi.put(plantList.remove(currentPlantListSize));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Producer Farmer for Aldi is exploded and can not be used anymore");
        } else {
            while (isStillProducer) {
                if (currentPlantListSize > 0) {
                    try {
                        bufferRewe.put(plantList.remove(currentPlantListSize));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Producer Farmer for Rewe is exploded and can not be used anymore");
        }
    }

    public void isStillProducer(boolean isStillProducer) {
        this.isStillProducer = isStillProducer;
    }

}
