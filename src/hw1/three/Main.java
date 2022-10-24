package hw1.three;

public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter();
        Turnstile turnstile1 = new Turnstile(counter, 10000);
        Turnstile turnstile2 = new Turnstile(counter, 10000);

        turnstile1.start();
        turnstile2.start();

        try {
            turnstile1.join();
            turnstile2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Value of this counter is " + counter);

    }
}

         // Nr. 1   Die Ausgabe ist Teilweise stark von 200 entfernt
         // Nr. 2   Die Ausgabe ist noch weiter entfernt, der Wert 20.000 wird eig. nie erreicht
         // Nr. 3   Die Threads müssten teilweise gleichzeitig ausgeführt werden wodurch nicht 2 auf die Summe addiert wird sondern nur 1, dadurch wird die maxValue nie erreicht wie vorgesehen
         // Nr. 4   ...
         // Nr. 5   Im Verhalten ist keine Änderung zu sehen, die Funktion scheint die gleiche wirkung zu haben
         // Nr. 6   Der Code funktioniert durch das synchronized bei der increase Methode wunderbar
         // Nr. 7   Die Funtion t1.start() führt einen Thread aus und ruft dann die Run-Methode auf, bei t2.run() wird der Call-Stack des Main-Threads aufgerufen und die Run-Methode ausgeführt. Es existiet hier also keine eine Thread Verwaltung die für den Thread erstellt wird wie bei .start()




