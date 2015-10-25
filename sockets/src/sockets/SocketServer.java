package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class SocketServer {
 
   public static void main(String args[]) {
 
       Vector<String> datosRecibidos = new Vector<String>();
 
       try {
             ServerSocket s = new ServerSocket(1234);
             System.out.println("Esperando conexiones...");
                   
             while (true) {
                    Socket cliente = s.accept();
                    BufferedReader entrada = new BufferedReader(
                             new InputStreamReader(cliente.getInputStream()));
                    PrintWriter salida = new PrintWriter(
             new OutputStreamWriter(cliente.getOutputStream()),true);
                    String datos = entrada.readLine();
                    if (datos.equals("DATOS")){
                           for (int n=0; n<datosRecibidos.size(); n++ ){
                                  salida.println(datosRecibidos.get(n));
                           }
                    } else {
                           datosRecibidos.add(0, datos);
                           salida.println("OK");
                    }
                    cliente.close();
             }
       } catch (IOException e) {
             System.out.println(e);
       }
}
}
