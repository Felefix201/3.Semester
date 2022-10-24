package hw4.readWriter.A1;

import java.util.Random;

public class Reader extends Thread{

    RWAccessControl<Integer> ac;

    public Reader(RWAccessControl<Integer> ac){
        this.ac = ac;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!isInterrupted()){
            Integer[] values = new Integer[0];
            try {
                sleep(random.nextInt(4000));
                values = ac.read();
                System.out.println("Read: " + values[0] + " " + values[1] + " " + values[2]);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}