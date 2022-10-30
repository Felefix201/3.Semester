package hw5.Stream;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime();
        IntStream.rangeClosed(0, 1_000_000).average().getAsDouble();
        System.out.println("Time: " + (System.nanoTime() - start) / 1_000_000 + "ms");
        start = System.nanoTime();
        IntStream.rangeClosed(0, 1_000_000).parallel().average().getAsDouble();
        System.out.println("Time: " + (System.nanoTime() - start) / 1_000_000 + "ms");
    }
    //Bei kleineren ranges ist im Regelfall die parallele Ausführung langsamer. Bei größeren ranges ist die parallele Ausführung weitaus schneller.
}
