package Lab1.src.Lab3.App2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class Broadband extends JPanel implements Observer, KeyListener {
    private final Square square1;
    private final Square square2;
    private final Square square3;
    private boolean startMoving = false;

    public Broadband() {
        square1 = new Square(this, 1, 200, 20);
        square2 = new Square(this, 1, 250, 10);
        square3 = new Square(this, -1, 800, 10);

        square1.addObserver(this);
        square2.addObserver(this);
        square3.addObserver(this);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the top and bottom parts of the frame
        g.drawRect(100, 10, 850, 50);
        g.drawRect(100, 160, 850, 50);
        // Draw the squares
        g.fillRect(square1.getPosition(), 100, 20, 20);
        g.fillRect(square2.getPosition(), 100, 20, 20);
        g.fillRect(square3.getPosition(), 100, 20, 20);
        // Draw the numbers
        g.drawString("3", square1.getPosition() + 10, 115);
        g.drawString("1", square2.getPosition() + 10, 115);
        g.drawString("2", square3.getPosition() + 10, 115);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            startMoving = true;
            Thread t1 = new Thread(square1);
            Thread t2 = new Thread(square2);
            Thread t3 = new Thread(square3);

            t1.start();
            t2.start();
            t3.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean isStartMoving() {
        return startMoving;
    }

    public Square getSquare1() {
        return square1;
    }

    public Square getSquare3() {
        return square3;
    }
}