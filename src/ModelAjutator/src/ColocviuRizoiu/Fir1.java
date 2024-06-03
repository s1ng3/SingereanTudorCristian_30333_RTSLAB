package ColocviuRizoiu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir1 extends Thread{
    int activity_min, activity_max, sleep, sleep_min, sleep_max;
    Semaphore semaphore;
    Object monitor;
    CyclicBarrier barrier;

    public Fir1(int activity_min, int activity_max, int sleep, int sleep_min, int sleep_max, Semaphore semaphore, Object monitor, CyclicBarrier barrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.semaphore = semaphore;
        this.monitor = monitor;
        this.barrier = barrier;
    }

    public void run() {
        while (true) {
            // Delay inainte de notify ca altfel da prea repede
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // State - 1
            System.out.println(this.getName() + " State 1");

            try {
                this.semaphore.acquire(3);
                System.out.println(this.getName() + " Acquire semaphore");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Notify monitor
            synchronized (monitor) {
                System.out.println(" Notifying");
                monitor.notify();
            }

            System.out.println(this.getName() + " State 2");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " State 3");

            try {
                Thread.sleep(500 * Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " Release semaphore");
            this.semaphore.release(3);

            System.out.println(this.getName() + " State 4");
            try {
                Thread.sleep(3*500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
