/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeksForGeeks;

import classesFornecidas.Le;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author bruno
 */
public class SimplesCliente {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 5056);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            while(true){
                System.out.println(dis.readUTF());
                String retornar = Le.umaString();
                dos.writeUTF(retornar);
                if(retornar.equals("Sair")){
                    System.out.println("Fecha conecção");
                    s.close();
                    break;
                }
                String recebido = dis.readUTF();
                System.out.println(recebido);
            }
            dis.close();
            dos.close();
        } catch (Exception e) {
        }
    }

}
