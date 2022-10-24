package hw4.readWriter.A3;

public class Main {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3};
        System.out.println("Initial: " + integers[0] + " " + integers[1] + " " + integers[2]);
        RWAccessControl<Integer> ac = new RWAccessControl<>(integers);
        new Writer(ac).start();
        new Writer(ac).start();
        new Reader(ac).start();
        new Reader(ac).start();

        //Fair mode means either the longest waiting thread gains access first or the longest waiting thread group, once the lock has been released.
//        new Reader(ac).start();
//        new Reader(ac).start();
//        new Reader(ac).start();
    }
}

