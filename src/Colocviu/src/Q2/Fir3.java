package Q2;

import java.util.concurrent.Semaphore;

public class Fir3 extends Thread{
    int activity_min, activity_max, sleep;
    Semaphore semaphore;
    Object monitor;



    public Fir3(int activity_min, int activity_max,  Semaphore semaphore, Object monitor) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.semaphore = semaphore;
        this.monitor = monitor;

    }

    public void run(){
            System.out.println(this.getName()+"State1");

            try {
                this.semaphore.acquire(1);
                System.out.println(this.getName() + " Acquire semaphore");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName()+"State2");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            this.semaphore.release(2);
            System.out.println(this.getName()+"State3");


    }

}
