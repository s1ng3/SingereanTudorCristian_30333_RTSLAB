package LockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fir1 extends Thread{
    int sleep;
    Lock lock;
    public Fir1(int sleep,  Lock lock) {
        this.lock = lock;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        lock.lock();
        try {
            System.out.println(this.getName() + " LOCKING THE LOCK");
            Thread.sleep(500 * sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " - STATE 3");
        System.out.println(this.getName() + "UNLOCKING THE LOCK");
        lock.unlock();
        System.out.println(this.getName() + " - STATE 4");
    }
}
