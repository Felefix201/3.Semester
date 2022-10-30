package hw5.copyOnWriteArrayList;

import java.util.List;

public class Writer extends Thread {
    private final List<Integer> list;
    private final int id;

    private int counter = 0;

    private Long averagePassedTime = 0L;

    public Writer(List<Integer> list, int id) {
        this.list = list;
        this.id = id;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (list) {
                for (int i = 0; i < list.size(); i++) {
                    long nanoTime = System.nanoTime();
                    list.set(i, list.get(i) + 1);
                    counter++;
                    averagePassedTime = (averagePassedTime + System.nanoTime() - nanoTime);
//                    System.out.println("Writer " + id + " write " + list.get(i));
                }
            }
        }
        averagePassedTime = averagePassedTime / counter;
        System.out.println("Average passed time of "+ id + " :" + averagePassedTime + "ns");

    }
}
