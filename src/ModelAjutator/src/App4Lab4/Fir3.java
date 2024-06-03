package App4Lab4;

public class Fir3 extends Thread {
    int activity_min, activity_max;
    Object monitor2;
    Fir1 th1;
    public Fir3(Object monitor2, int activity_min, int activity_max, Fir1 th1) {
        this.monitor2 = monitor2;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.th1 = th1;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " -  STATE 1");
        synchronized (monitor2) {
            try {
                System.out.println("WAIT MONITOR 1");
                monitor2.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(this.getName() + " - STATE 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");

        try {
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("final state");
    }
}
