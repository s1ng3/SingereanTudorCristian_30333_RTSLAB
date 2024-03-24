package Lab1.src.Lab3.App2;

import java.util.Observable;
import java.util.Random;

public class Square extends Observable implements Runnable {
    private int position;
    private int speed;
    private final Broadband broadband;
    private final int direction;
    private final int maxSpeed;

    public Square(Broadband broadband, int direction, int startPosition, int maxSpeed) {
        this.broadband = broadband;
        this.speed = new Random().nextInt(maxSpeed) + 1;
        this.direction = direction;
        this.position = startPosition;
        this.maxSpeed = maxSpeed;
    }

    public void setSpeed(int speed) {
        if (speed <= maxSpeed) {
            this.speed = speed;
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (broadband) {
                position += speed * direction;
                setChanged();
                notifyObservers();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int getPosition() {
        return position;
    }
}