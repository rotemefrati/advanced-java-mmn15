package main.java.com.maman15.q2;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Represents a philosopher thread that alternates between thinking and eating.
public class Philosopher extends Thread {
    private final ImageView imageView;
    private final Stick leftStick;
    private final Stick rightStick;

    public Philosopher(ImageView imageView, Stick leftStick, Stick rightStick) {
        this.imageView = imageView;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }

    private void changeImage(String imageUrl) {
        String imagePath = "file:" + System.getProperty("user.dir") + "/src/main/resources/" + imageUrl;
        Platform.runLater(() -> imageView.setImage(new Image(imagePath)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                eat();
                think();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        changeImage("Pictures/NotEating.png");
        Thread.sleep((long) (Math.random() * 2000));
    }

    // Simulates the eating behavior of the philosopher.
    // Acquires both chopsticks and changes the image to reflect the eating state.
    private void eat() throws InterruptedException {
        synchronized (leftStick) {
            leftStick.pickUp();
            synchronized (rightStick) {
                rightStick.pickUp();
                changeImage("Pictures/Eating.png");
                Thread.sleep((long) (Math.random() * 2000));
                rightStick.putDown();
            }
            leftStick.putDown();
        }
    }
}