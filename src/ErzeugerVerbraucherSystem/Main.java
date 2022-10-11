package ErzeugerVerbraucherSystem;

public class Main {

        public static void main(String[] args) {
            Buffer buffer = new Buffer();
            Producer producer1 = new Producer(buffer);
            Producer producer2 = new Producer(buffer);
            Consumer consumer1 = new Consumer(buffer);
            Consumer consumer2 = new Consumer(buffer);
            Consumer consumer3 = new Consumer(buffer);
            Viewer viewer = new Viewer(buffer);

            producer1.start();
            producer2.start();
            consumer1.start();
            consumer2.start();
            consumer3.start();
            viewer.start();

            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("XXXXXXXXXXXXXXXXXX");
            consumer1.interrupt();
            consumer2.interrupt();
            consumer3.interrupt();

        }

}
