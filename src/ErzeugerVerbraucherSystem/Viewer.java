package ErzeugerVerbraucherSystem;

public class Viewer extends Thread{

    private Buffer buffer;

    public Viewer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(buffer.peek());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
