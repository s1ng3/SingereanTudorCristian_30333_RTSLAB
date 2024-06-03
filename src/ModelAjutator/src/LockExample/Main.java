package LockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Fir1 th1 = new Fir1(3, lock);
        Fir1 th2 = new Fir1(3, lock);

        th1.start();
        th2.start();
    }
}
