/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeRede;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class Teste1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Teste1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = "Boas Romero";
        InetAddress ip = InetAddress.getByName("192.168.0.116");
        byte[] data = str.getBytes();
        System.out.println("Enviou " + data.length + " bytes");
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),
                ip, 6666); // Endereço e porta de envio
        ds.send(dp);
        ds.close();
    }

}
