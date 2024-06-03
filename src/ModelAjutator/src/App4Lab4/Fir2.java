package App4Lab4;

public class Fir2 extends Thread {
    int activity_min, activity_max;
    Object monitor1;
    Fir1 th1;
    public Fir2(Object monitor1, int activity_min, int activity_max, Fir1 th1) {
        this.monitor1 = monitor1;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.th1 = th1;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " -  STATE 1");
        synchronized (monitor1) {
            try {
                System.out.println("WAIT MONITOR 1");
                monitor1.wait();
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

    }
}
