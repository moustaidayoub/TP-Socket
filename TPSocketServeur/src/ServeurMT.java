
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
public class ServeurMT extends Thread {
  private int numero;
  private List<Socket> clients=new ArrayList();
    @Override
    public void run() {
      try {
          ServerSocket ss=new ServerSocket(234);
          System.out.println("waiting for connection...");
          while (true) {
               Socket s=ss.accept();
               clients.add(s);
               ++numero;
               new ServiceClient(numero,s,clients).start();
          }
      } catch (IOException ex) {
          Logger.getLogger(ServeurMT.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }

    public static void main(String[] args) {
        new ServeurMT().start();
    }
}
