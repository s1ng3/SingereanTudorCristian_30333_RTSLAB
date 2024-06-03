package ColocviuRizoiu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir2 extends Thread{

    int activity_min, activity_max, sleep_min, sleep_max;
    Object monitor;
    Semaphore semaphore;
    CyclicBarrier barrier;

    public Fir2(int activity_min, int activity_max, int sleep_max, int sleep_min, Object monitor, Semaphore semaphore, CyclicBarrier barrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.monitor = monitor;
        this.semaphore = semaphore;
        this.barrier = barrier;

    }

    public void run() {

        while (true) {

            System.out.println(this.getName() + " State 1");

            try {
                this.semaphore.acquire(2);
                System.out.println(this.getName() + " Acquire semaphore");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " State 2");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            System.out.println(this.getName() + " State 3");


            synchronized (monitor) {

                try {
                    System.out.println(this.getName() + " Release semaphore");
                    this.semaphore.release(2);
                    System.out.println(this.getName() + " Waiting for monitor");
                    monitor.wait();
                    Thread.sleep(500 * Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(this.getName() + " State 4");
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
