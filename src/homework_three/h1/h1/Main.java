package homework_three.h1.h1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] binarySemaphores = new Semaphore[5];
        for (int i = 0; i < binarySemaphores.length; i++) {
            binarySemaphores[i] = new Semaphore(0);
        }
        new SemaphoreSauceKochen(binarySemaphores);
        new SemaphoreZwiebelnSchneiden(binarySemaphores);
        new SemaphoreTomatenSchneiden(binarySemaphores);
        new NudelnKochen(binarySemaphores);
        new SemaphoreServieren(binarySemaphores);
    }
}
