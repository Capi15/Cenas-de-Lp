/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treads;

/**
 *
 * @author bruno
 */
public class NamedRunnable implements Runnable {

    private String name; // O nome deste thread.

    public NamedRunnable(String name) { // Constructor dá nome ao thread.
        this.name = name;
    }

    public void run() { // O metodo run imprime uma messagem.
        System.out.println("Greetings from runnable ’" + name + "’!");
    }

    public static void main(String[] args) {
        NamedRunnable greetings = new NamedRunnable("Fred");
        Thread greetingsThread = new Thread(greetings);
        greetingsThread.start();
    }
}
