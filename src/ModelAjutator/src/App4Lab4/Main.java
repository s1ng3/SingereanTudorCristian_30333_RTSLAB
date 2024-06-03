package App4Lab4;

public class Main {
    public static void main(String[] args) {

        Object monitor1 = new Object();
        Object monitor2 = new Object();
        Fir1 thread1 = new Fir1(monitor1, monitor2, 7, 2, 3);
        Fir2 thread2 = new Fir2(monitor1, 3, 5, thread1);
        Fir3 thread3 = new Fir3(monitor2, 4, 6, thread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
