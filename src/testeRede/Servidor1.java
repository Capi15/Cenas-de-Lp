/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeRede;

import java.io.IOException;
import java.net.*;
import java.util.logging.*;



/**
 *
 * @author bruno
 */
public class Servidor1 {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(6666);
        } catch (SocketException ex) {
            Logger.getLogger(Servidormemoteste.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = "Bemvindo!!!";
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName("172.16.160.236");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Servidormemoteste.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] data = str.getBytes();
        System. out .println("Enviou " + data.length + " bytes");
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 6666); 
        try { 
            ds.send(dp);
        } catch (IOException ex) {
            Logger.getLogger(Servidormemoteste.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.close();
       
        
    }

    private static class Servidormemoteste {

        public Servidormemoteste() {
        }
    }
    

}
