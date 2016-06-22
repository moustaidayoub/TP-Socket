/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayoub MOUSTAID
 */
public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(234);
            System.out.println("waiting for connection...");
            Socket s=ss.accept();
            InputStream is=s.getInputStream();
            //pour lire une chaine
            //InputStreamReader isr=new InputStreamReader(is);
            //BufferedReader br=new BufferedReader(isr);
            //String s=br.readLine();
            OutputStream os=s.getOutputStream();
            //pour envoyer une chaine
            //PrintWriter pr=new PrintWriter(os,true);
            //pr.println("chaine a envoyer");
            System.out.println("waiting for number...");
            int nmb=is.read();
            int rep=nmb*5;
            os.write(rep);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
