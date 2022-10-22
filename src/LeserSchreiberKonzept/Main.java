package LeserSchreiberKonzept;

public class Main {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3};
        System.out.println("Initial: " + integers[0] + " " + integers[1] + " " + integers[2]);
        RWAccessControl<Integer> ac = new RWAccessControl<>(integers);
        new Writer(ac).start();
        new Writer(ac).start();
        new Reader(ac).start();
        new Reader(ac).start();
        new Reader(ac).start();
        new Reader(ac).start();
        new Reader(ac).start();
    }
}

