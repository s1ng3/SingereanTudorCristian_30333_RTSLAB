package Lab1.src.Lab3.Example3;

public class Main {

    public static int sumOfDividers = 0;

    public static void main(String[] args) {

        JoinTestThread w1 = new JoinTestThread("Thread 1", null, 50001);

        JoinTestThread w2 = new JoinTestThread("Thread 2", w1, 20001);

        w1.start();
        w2.start();

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final result
        System.out.println("Sum of dividers: " + sumOfDividers);
    }
}