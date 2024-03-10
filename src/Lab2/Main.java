package Lab2.src.Lab2;

public class Main {

    private static final int noOfThreads=9;

    private static final int processorLoad=1000000;

    public static void main(String args[]){

        Window win=new Window(noOfThreads);

        for(int i =0; i<noOfThreads; i++){

            new Fir(i,i+2,win,processorLoad).start();

        }
    }
}