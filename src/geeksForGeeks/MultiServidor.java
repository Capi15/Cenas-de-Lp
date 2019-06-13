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
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author bruno
 */
public class MultiServidor {

    public static Vector<ClientHandler> ar = new Vector<>();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1234);
        Socket s;
        while (true) {
            s = ss.accept();
            System.out.println("Cliente aceito");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            ClientHandler mtch = new ClientHandler(s, dis, dos, "sbtdjtyjftyj", true);

            Thread t = new Thread(mtch);
            ar.add(mtch);

            t.start();
        }

    }

    public static class ClientHandler extends Thread {

        final Socket s;
        final DataInputStream dis;
        final DataOutputStream dos;
        private String name;
        boolean isLoggedIn;

        public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, String name, boolean isLoggedIn) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.name = name;
            this.isLoggedIn = isLoggedIn;
        }

        @Override
        public void run() {
            String recebido;
            while (true) {
                try {
                    recebido = dis.readUTF();
                    System.out.println(recebido);
                    if (recebido.equals("logout")) {
                        this.isLoggedIn = false;
                        this.s.close();
                    }
                    StringTokenizer st = new StringTokenizer(recebido, "#");
                    String MsgToSend = st.nextToken();
                    String recipient = st.nextToken();
                    for (ClientHandler mc : MultiServidor.ar) {
                        if (mc.name.equals(recipient) && mc.isLoggedIn) {
                            mc.dos.writeUTF(mc.name + ": " + MsgToSend);
                            break;
                        }
                    }

                } catch (Exception e) {
                }
            }
        }
    }

}
