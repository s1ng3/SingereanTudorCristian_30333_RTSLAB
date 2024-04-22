package Lab1.src.Lab5.src.Ex7dot4;
import java.lang.invoke.SwitchPoint;
import  java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread{

    final Semaphore sem;
    int[] times;

    public ExecutionThread(Semaphore sem, int[] times){
        this.sem = sem;
        this.times = times;
    }

    public void run(){

        while(true){
            System.out.println(this.getName() + " - STATE 1");
            try{
                sem.acquire(1);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            sem.release(1);
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)times[2] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }
}
