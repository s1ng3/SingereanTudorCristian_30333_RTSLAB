package Lab1.src.Lab2.Ex2;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int noOfThreads = 8;
    private static final int processorLoad = Integer.MAX_VALUE;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window(noOfThreads);
            for (int i = 0; i < noOfThreads; i++) {
                Thread thread = new Thread(new Fir(i, window, processorLoad));
                thread.setPriority(i % 10 + 1);
                thread.start();
            }
        });
    }
}