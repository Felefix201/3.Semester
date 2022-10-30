package hw5.copyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> syncList = Collections.synchronizedList(list);
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
        Reader readerSyncList = new Reader(syncList, 1);
        Writer writerSyncList = new Writer(syncList, 2);
        Reader readerCopyONWriteArrayList = new Reader(syncList, 3);
        Writer writerCopyONWriteArrayList = new Writer(syncList, 4);

        readerSyncList.start();
        writerSyncList.start();

        //Die prints der Reader und Writer sind für Leserlichkeit auskommentiert. 20 Sekunden für die Ergebnisse warten


        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                readerSyncList.interrupt();
                writerSyncList.interrupt();
            }
        }, 10000);

        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                readerCopyONWriteArrayList.start();
                writerCopyONWriteArrayList.start();
            }
        }, 10000);
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                readerCopyONWriteArrayList.interrupt();
                writerCopyONWriteArrayList.interrupt();
            }
        }, 20000);
    }
}
//Konklusion nach einigen Benchmarks: Leser sind identisch schnell, Schreiber sind bei SyncList schneller, da sie nicht kopieren müssen.