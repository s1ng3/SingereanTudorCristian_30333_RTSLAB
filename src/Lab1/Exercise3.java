package Lab1.src.Lab1;
import java.util.Arrays;
import java.util.Random;

public class Exercise3 {

    public static void main(String arg[]) {

        Random rand = new Random();
        int bound = 1000; // Set the bound to a higher value
        int[] arrayans = new int[10];

        for (int i = 0; i < 10; i++) {
            int random = rand.nextInt(bound);
            arrayans[i] = random;
        }

        Arrays.sort(arrayans);

        System.out.println("Sorted Numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print(arrayans[i] + " ");
        }
    }
}
