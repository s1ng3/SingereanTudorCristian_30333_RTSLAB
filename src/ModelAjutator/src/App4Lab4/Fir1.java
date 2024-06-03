package App4Lab4;

public class Fir1 extends Thread {
    int sleep, activity_min, activity_max;
    Object monitor1, monitor2;
    public Fir1(Object monitor1, Object monitor2, int sleep, int activity_min, int activity_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " -  STATE 1");

        try {
            Thread.sleep(500 * sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (monitor1) {
            System.out.println("NOTIFI MONITOR 1");
            monitor1.notify();
        }
        synchronized (monitor2) {
            System.out.println("NOTIFI MONITOR 2");
            monitor2.notify();
        }
        System.out.println(this.getName() + " - STATE 3");

    }
}
