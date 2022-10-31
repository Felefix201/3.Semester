package allHomework.WE3.two;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>(10);
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Thread t1 = new Thread(() -> {
            try {
                queue2.put(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    if (list.get(i) == queue2.get()) {
                        System.out.println("Test passed");
                    } else {
                        System.out.println("Test failed");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }

    @org.junit.jupiter.api.Test
    void test() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        Thread t1 = new Thread(() -> {
            try {
                queue.put(1);
                queue.put(2);
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                assertEquals(1, queue.get());
                assertEquals(2, queue.get());
                assertEquals(3, queue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                assertNotEquals(1, queue.get());
                assertNotEquals(2, queue.get());
                assertNotEquals(3, queue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
//        t3.start();
        t1.join();
        t2.join();
        t3.join();
        queue.put(1);
        queue.put(2);
        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
    }

    @org.junit.jupiter.api.Test
    void test2() {
        LinkedBlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>(10);
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Thread t1 = new Thread(() -> {
            try {
                queue2.put(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    assertEquals(list.get(i), queue2.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

    }

    @org.junit.jupiter.api.Test
    void put() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }
}