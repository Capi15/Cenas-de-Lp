/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeksForGeeks;

import classesFornecidas.Le;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author bruno
 */
public class MultiClient {

    final static int ServerPort = 1234;

    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress ip = InetAddress.getByName("192.168.0.100");
        Socket s = new Socket(ip, 1234);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String msg = Le.umaString();
                    try {
                        dos.writeUTF(msg);
                        if(msg.equals("logout")){
                            break;
                        }
                    } catch (IOException e) {
                    }
                }
            }
        });
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String recebido = dis.readUTF();
                        System.out.println(recebido);
                    } catch (Exception e) {
                    }
                }
            }
        });
        readMessage.setDaemon(true);
        sendMessage.start();
        readMessage.start();
    }
    
}
