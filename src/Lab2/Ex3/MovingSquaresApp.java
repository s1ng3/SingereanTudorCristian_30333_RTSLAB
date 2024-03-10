package Lab2.src.Ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovingSquaresApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moving Squares");
            frame.setSize(500, 500);
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Square[] squares = new Square[3];
            SquareThread[] threads = new SquareThread[3];

            for (int i = 0; i < 3; i++) {
                squares[i] = new Square(50 * (i + 1), 50, 30);
                SquarePanel squarePanel = new SquarePanel(squares[i]);
                threads[i] = new SquareThread(squares[i], 2, 5, squarePanel);
                frame.add(squarePanel);
            }

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    stopThreads(threads);
                }
            });

            frame.setVisible(true);

            startThreads(threads);
        });
    }

    private static void startThreads(SquareThread[] threads) {
        for (SquareThread thread : threads) {
            thread.start();
        }
    }

    private static void stopThreads(SquareThread[] threads) {
        for (SquareThread thread : threads) {
            thread.stopThread();
        }
    }

    private static class Square {
        private int x;
        private int y;
        private int size;

        public Square(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public void move(int speed) {
            y += speed;
        }

        public int getY() {
            return y;
        }

        public int getSize() {
            return size;
        }
    }

    private static class SquarePanel extends JPanel {
        private Square square;

        public SquarePanel(Square square) {
            this.square = square;
            setPreferredSize(new Dimension(100, 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (square.getY() < 400) {
                g.drawRect(10, square.getY(), square.getSize(), square.getSize());
            }
        }
    }

    private static class SquareThread extends Thread {
        private Square square;
        private boolean running;
        private int minSpeed;
        private int maxSpeed;
        private SquarePanel squarePanel;

        public SquareThread(Square square, int minSpeed, int maxSpeed, SquarePanel squarePanel) {
            this.square = square;
            this.minSpeed = minSpeed;
            this.maxSpeed = maxSpeed;
            this.running = true;
            this.squarePanel = squarePanel;
        }

        public void run() {
            while (running && square.getY() < 400) {
                square.move((int) (Math.random() * (maxSpeed - minSpeed + 1) + minSpeed));
                try {
                    SwingUtilities.invokeAndWait(() -> squarePanel.repaint());
                    sleep(50);
                } catch (InterruptedException | java.lang.reflect.InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopThread() {
            running = false;
        }
    }
}

