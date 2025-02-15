package main.java.com.maman15.q2;

public class Stick {
    private boolean inUse = false;

    // Attempts to pick up the chopstick, entering wait state if it's in use.
    // Uses synchronization to avoid deadlock.
    public synchronized void pickUp() throws InterruptedException {
        while (inUse) {
            wait();
        }
        inUse = true;
    }

    // Puts down the chopstick, making it available for other philosophers.
// Notifies waiting philosophers.
    public synchronized void putDown() {
        inUse = false;
        notifyAll();
    }
}