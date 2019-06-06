/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeRede;

import java.net.*;
import java.io.*;

/**
 *
 * @author bruno
 */
public class Servidor2 {
    public static void main(String[] args) throws Exception{
            ServerSocket ss = new ServerSocket(6666);

    System.out.println (
    "Aceita Conections...");
        Socket s = ss.accept();

    System.out.println (
    "Conectado com "+s.getInetAddress().getHostAddress());
        
        DataInputStream din = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String strCli = "", strSer = "";

    while (!strCli.equals ( 
        "stop")){
            strCli = din.readUTF();
        System.out.println("Cliente " + strCli);
        strSer = br.readLine();
        dout.writeUTF(strSer);
        dout.flush();
    }

    din.close ();

    s.close ();

    ss.close ();

}


}
