/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeRede;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author bruno
 */
public class Teste2 {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("192.168.0.109",6325);
        System.out.println("Conetado");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String strCli = "", strSer = "";
        while(!strCli.equals("stop")){
            strCli=br.readLine();
            dout.writeUTF(strCli);
            dout.flush();
            strSer = din.readUTF();
            System.out.println("cliente "+strSer);
            
        }
        dout.close();
        s.close();
    }

}
