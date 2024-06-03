package ColocviuRizoiu;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        CyclicBarrier barrier = new CyclicBarrier(2);
        Object monitor = new Object();

        Fir1 thread1 = new Fir1(3,5,3,4,6,semaphore,monitor,barrier);
        Fir2 thread2 = new Fir2(2,4,5,7,monitor,semaphore,barrier);

        thread2.start();
        thread1.start();

    }
}
