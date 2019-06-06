/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treads;

import java.time.Instant;
import static java.time.Instant.MAX;

/**
 *
 * @author bruno
 */
public class CountPrimesThread {

    int id; // An id number for this thread; specified in the constructor.

    public CountPrimesThread(int id) {
        this.id = id;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        int count = countPrimes(2, MAX);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Thread " + id + " counted "
                + count + " primes in " + (elapsedTime / 1000.0) + " seconds.");
    }

    private int countPrimes(int i, Instant MAX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        int numberOfThreads = 0;
        while (numberOfThreads < 1 || numberOfThreads > 25) {
            System.out.print("How many threads do you want to use (from 1 to 25) ? ");
            numberOfThreads = Le.umInt();
            if (numberOfThreads < 1 || numberOfThreads > 25) {
                System.out.println("Please enter a number between 1 and 25 !");
            }
        }
        System.out.println("\nCreating " + numberOfThreads + " prime-counting threads...");
        CountPrimesThread[] worker = new CountPrimesThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            worker[i] = new CountPrimesThread(i);
        }
        for (int i = 0; i < numberOfThreads; i++) {
            worker[i].start();
        }
        System.out.println("Threads have been created and started.");
    }
}
