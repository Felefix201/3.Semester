package hw4.readWriter.A3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Writer extends Thread{

    RWAccessControl<Integer> ac;

    public Writer(RWAccessControl<Integer> ac){
        this.ac = ac;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!isInterrupted()){
            Map<Integer,Integer> changeMap = new HashMap<>();
            changeMap.put(random.nextInt(3), random.nextInt(10));
            changeMap.put(random.nextInt(3), random.nextInt(10));
            changeMap.put(random.nextInt(3), random.nextInt(10));
            try {
                sleep(random.nextInt(3000));
                ac.write(changeMap);
                System.out.println("Write: " + changeMap.get(0) + " " + changeMap.get(1) + " " + changeMap.get(2));
            } catch (InterruptedException e) {break;}
        }
    }
}
