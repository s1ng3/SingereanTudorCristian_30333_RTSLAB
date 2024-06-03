package Q2;

import java.util.concurrent.Semaphore;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        Semaphore semaphore = new Semaphore(2);


        while(true) {

            Fir1 thread1 = new Fir1(2, 4, semaphore, monitor);
            Fir2 thread2 = new Fir2(3, 6, 6, semaphore, monitor);
            Fir3 thread3 = new Fir3(4, 7, semaphore, monitor);

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();
        }
    }
}
