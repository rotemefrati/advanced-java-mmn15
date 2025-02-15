package main.java.com.maman15.q2;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class DiningPhilosophersController {

    @FXML
    private ImageView firstPhilosopher, secondPhilosopher, thirdPhilosopher, fourthPhilosopher, fifthPhilosopher;

    private Philosopher[] philosophers;
    private Stick[] sticks;

    public void initialize() {
        philosophers = new Philosopher[5];
        sticks = new Stick[5];

        for (int i = 0; i < 5; i++) {
            sticks[i] = new Stick();
        }

        philosophers[0] = new Philosopher(firstPhilosopher, sticks[4], sticks[0]);
        philosophers[1] = new Philosopher(secondPhilosopher, sticks[0], sticks[1]);
        philosophers[2] = new Philosopher(thirdPhilosopher, sticks[1], sticks[2]);
        philosophers[3] = new Philosopher(fourthPhilosopher, sticks[2], sticks[3]);
        philosophers[4] = new Philosopher(fifthPhilosopher, sticks[3], sticks[4]);

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}