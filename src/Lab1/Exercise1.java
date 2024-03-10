package Lab1.src.Lab1;

import java.util.Scanner;
class Exercise1 {

    int real, image;

    public Exercise1(int r, int i) {
        this.real = r;
        this.image = i;
    }

    public void showC() {
        System.out.print(this.real + " +i" + this.image);
    }

    public static Exercise1 add(Exercise1 n1, Exercise1 n2) {
        Exercise1 res = new Exercise1(0, 0);
        res.real = n1.real + n2.real;
        res.image = n1.image + n2.image;
        return res;
    }

    public static Exercise1 subtract(Exercise1 n1, Exercise1 n2) {
        Exercise1 res = new Exercise1(0, 0);
        res.real = n1.real - n2.real;
        res.image = n1.image - n2.image;
        return res;
    }

    public static Exercise1 multiply(Exercise1 n1, Exercise1 n2) {
        Exercise1 res = new Exercise1(0, 0);
        res.real = (n1.real * n2.real) - (n1.image * n2.image);
        res.image = (n1.real * n2.image) + (n1.image * n2.real);
        return res;
    }public static void main(String arg[]) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the real part of the first complex number: ");
        int real1 = scanner.nextInt();
        System.out.print("Enter the imaginary part of the first complex number: ");
        int image1 = scanner.nextInt();

        System.out.print("Enter the real part of the second complex number: ");
        int real2 = scanner.nextInt();
        System.out.print("Enter the imaginary part of the second complex number: ");
        int image2 = scanner.nextInt();

        Exercise1 c1 = new Exercise1(real1, image1);
        Exercise1 c2 = new Exercise1(real2, image2);

        System.out.println("\nSelect operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");

        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();

        Exercise1 result;

        switch (choice) {
            case 1:
                result = add(c1, c2);
                System.out.println("\nAddition result:");
                result.showC();
                break;
            case 2:
                result = subtract(c1, c2);
                System.out.println("\nSubtraction result:");
                result.showC();
                break;
            case 3:
                result = multiply(c1, c2);
                System.out.println("\nMultiplication result:");
                result.showC();
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
