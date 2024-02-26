package Lab1.src.Lab1;

public class Exercise2 {

    public static void main(String arg[]) {

        int mat1[][] = {{2,3,1}, {7,1,6}, {9,2,4}};
        int mat2[][] = {{8,5,3}, {3,9,2}, {2,7,3}};

        int c[][]=new int[3][3];

        System.out.println("\n Addition of 2 matrices: \n");

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                c[i][j]=mat1[i][j]+mat2[i][j];
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }


        int c2[][] = new int[3][3];

        System.out.println("\n Multiplication of 2 matrices: \n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c2[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    c2[i][j] += mat1[i][k] * mat2[k][j];
                }
                System.out.print(c2[i][j] + " ");
            }
            System.out.println();
        }
    }
}