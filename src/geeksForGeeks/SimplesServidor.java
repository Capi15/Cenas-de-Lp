/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeksForGeeks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bruno
 */
public class SimplesServidor {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        while (true) {
            Socket s = null;
            try {

                s = ss.accept();
                System.out.println("cliente conectou: " + s);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                Thread t = new ClientHandler(s, dis, dos);
                t.start();
            } catch (Exception e) {
                s.close();
            }
        }
    }

    public static class ClientHandler extends Thread {

        final Socket s;
        final DataInputStream dis;
        final DataOutputStream dos;
        DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

        public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
        }

        public void run() {
            String recebido;
            String retornar;
            while (true) {
                try {
                    dos.writeUTF("O que é que queres ? [Data | Hora]..\n" + "Escrever Sair para terminar connecção");
                    recebido = dis.readUTF();

                    if (recebido.equals("Sair")) {
                        System.out.println("Cliente enviou uma saída");
                        this.s.close();
                        break;
                    }
                    Date data = new Date();
                    switch (recebido) {
                        case "Data":
                            retornar = fordate.format(data);
                            dos.writeUTF(retornar);
                            break;
                        case "Hora":
                            retornar = fortime.format(data);
                            dos.writeUTF(retornar);
                            break;
                        default:
                            dos.writeUTF("Comando Inválido");
                            break;
                    }
                } catch (Exception e) {
                }
            }
            try {
                this.dis.close();
                this.dos.close();
            } catch (Exception e) {
            }
        }
    }
}
