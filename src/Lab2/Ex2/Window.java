package Lab1.src.Lab2.Ex2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Window extends JFrame implements Observer {
    private static final int WINDOW_WIDTH = 450;
    private static final int WINDOW_HEIGHT = 400;
    private final ArrayList<JProgressBar> bars = new ArrayList<>();

    public Window(int nrThreads) {
        initializeWindow(nrThreads);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeWindow(int n) {
        setLayout(null);
        for (int i = 0; i < n; i++) {
            JProgressBar progressBar = new JProgressBar();
            progressBar.setMaximum(1000);
            progressBar.setBounds(50, (i + 1) * 30, 350, 20);
            add(progressBar);
            bars.add(progressBar);
        }
    }

    public void setProgressValue(int id, int val) {
        bars.get(id).setValue(val);
    }

    @Override
    public void update(Observable o, Object arg) {
        Fir worker = (Fir) arg;
        System.out.println("Thread id " + worker.getId() + " value " + worker.getC() + " changed");
        bars.get(worker.getId()).setValue(worker.getC());
    }
}