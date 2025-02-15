package main.java.com.maman15.q1;

public class PrimeNumbers extends Thread {

    NumbersPool numPool;

    // Constructor takes a NumbersPool instance for thread synchronization
    public PrimeNumbers(NumbersPool numPool) {
        this.numPool = numPool;
    }

    @Override
    public void run() {
        super.run();
        int num;
        do {
            // Allocate a number from the pool, add it as a prime, and print it
            num = numPool.allocateNum();
            numPool.addPrimeNum(num);
        } while(num != -1);
    }
}