package main.java.com.maman15.q1;

import java.util.TreeSet;

public class NumbersPool {

    private TreeSet<Integer> allNums = new TreeSet<>();
    private TreeSet<Integer> primeNums = new TreeSet<>();
    private int done;

    // Constructor initializes the NumbersPool with a given size
    public NumbersPool(int size) {
        done = size;
        fillTree(size);
    }

    // Allocates a number from the pool, removes it, and returns it
    public synchronized int allocateNum() {
        if(!allNums.isEmpty()) {
            int num = allNums.first();
            allNums.remove(num);
            return num;
        }
        return -1;
    }

    // Adds a prime number to the set and decrements the 'done' counter
    public synchronized void addPrimeNum(int num) {
        if(isPrimeNum(num)) {
            primeNums.add(num);
        }
        done--;
        notifyAll();
    }

    // Waits until all threads finish and then prints the prime numbers
    public synchronized void printPrimeNums() {
        while(done > 0) {
            try {
                wait();
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(primeNums);
    }

    // Checks if a given number is prime
    public boolean isPrimeNum(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Fills the TreeSet with numbers from 1 to the specified size
    private void fillTree(int size) {
        for(int i = 0; i < size; i++) {
            allNums.add(i+1);
        }
    }
}