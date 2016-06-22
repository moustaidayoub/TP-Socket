/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayoub MOUSTAID
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket s=new Socket("localhost",234);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            Scanner clavier=new Scanner(System.in);
            System.out.println("give number : ");
            int nmb=clavier.nextInt();
            int rep=is.read();
            System.out.println("Reponse : "+rep);

                        
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
