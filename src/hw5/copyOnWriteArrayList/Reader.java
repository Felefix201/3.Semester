package hw5.copyOnWriteArrayList;

import java.util.List;

public class Reader extends Thread {
    private final List<Integer> list;
    private final int id;

    private int counter = 0;

    private Long averagePassedTime = 0L;

    public Reader(List<Integer> list, int id) {
        this.list = list;
        this.id = id;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (list) {
                for (int i = 0; i < list.size(); i++) {
                    long nanoTime = System.nanoTime();
//                    System.out.println("Reader " + id + " read " + list.get(i));
                    counter++;
                    averagePassedTime = (averagePassedTime + System.nanoTime() - nanoTime);
                }
            }
        }
        averagePassedTime = averagePassedTime / counter;
        System.out.println("Average passed time of "+ id + " :" + averagePassedTime + "ns");
    }
}
