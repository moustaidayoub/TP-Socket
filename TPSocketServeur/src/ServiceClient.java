
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayoub MOUSTAID
 */
public class ServiceClient extends Thread {
    private int numero;
    private Socket client;
    private List<Socket> clients;

    public ServiceClient(int numero, Socket client,List<Socket> clients) {
        this.numero = numero;
        this.client = client;
        this.clients=clients;
    }

    @Override
    public void run() {
        try {
            InputStream is = client.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            OutputStream os=client.getOutputStream();
            PrintWriter pw=new PrintWriter(os,true);
            System.out.println("Connexion du client numero :"+numero);
            pw.println("vous etes le client numero : "+numero);
            while (true) {
                String req=br.readLine();
                pw.println("length = "+req.length());
                for(Socket sock:clients)
                {
                new PrintWriter(sock.getOutputStream(),true).println("to all : "+req); 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
