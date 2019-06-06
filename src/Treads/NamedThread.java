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
public class NamedThread {

    private String name; // O nome deste thread.

    public NamedThread(String name) { // Construtor dá nome ao thread.
        this.name = name;
    }

    public void run() { // O método run imprime uma messagem.
        System.out.println("Greetings from thread ’" + name + "’!");
    }

    public static void main(String args[]) {
        NamedThread greetings = new NamedThread("Fred");
        greetings.start();
        System.out.println("Thread has been started");
    }

    private void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
