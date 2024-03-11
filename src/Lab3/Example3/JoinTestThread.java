package Lab1.src.Lab3.Example3;

public class JoinTestThread extends Thread {
    private Thread t;
    private int number;

    JoinTestThread(String n, Thread t, int number) {
        this.setName(n);
        this.t = t;
        this.number = number;
    }

    public void run() {
        System.out.println(getName() + " has entered the run() method");

        try {
            if (t != null) {
                t.join();
            }

            int dividersSum = calculateDividersSum(number);

            Main.sumOfDividers += dividersSum;

            System.out.println(getName() + " determined dividers sum: " + dividersSum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int calculateDividersSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}