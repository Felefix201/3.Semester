package allHomework.WE3.one;

public class cookingWithSemaphore {
    private static BinarySemaphore tomatenSchneiden = new BinarySemaphore();
    private static BinarySemaphore zwiebelnSchneiden = new BinarySemaphore();
    private static BinarySemaphore sauceKochen = new BinarySemaphore();
    private static BinarySemaphore nudelnKochen = new BinarySemaphore();
    private static BinarySemaphore servieren = new BinarySemaphore();

    public static void main(String[] args) {

        new Thread (()-> {
            try {
                sauceKochen.acquire();
                nudelnKochen.acquire();
                System.out.println("Gericht wird serviert");
                servieren.release();
            } catch (InterruptedException e) {
                new InterruptedException("Servieren was called at the wrong time");
            }
        }).start();

        new Thread (()-> {
            try {
                tomatenSchneiden.acquire();
                zwiebelnSchneiden.acquire();
                System.out.println("Sauce wird gekocht");
                sauceKochen.release();
            } catch (InterruptedException e) {
                new InterruptedException("SauceKochen was called at the wrong time");
            }
        }).start();

        new Thread (()-> {
            System.out.println("Nudeln werden gekocht");
            nudelnKochen.release();
        }).start();

        new Thread (()-> {
            System.out.println("Tomaten wurden geschnitten");
            tomatenSchneiden.release();
        }).start();

        new Thread (()-> {
            System.out.println("Zwiebeln wurden geschnitten");
            zwiebelnSchneiden.release();
        }).start();




    }
}
