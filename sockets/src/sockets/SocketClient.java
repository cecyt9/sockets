package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
//        para conectarns desde otros equipos hay que agregar cambiar 
//        localhost por la ip del servidor
        String ip = "192.168.1.123";
        int puerto = 1234;
        System.out.println(" socket " + ip + " " + puerto);
        try {
            Socket sk = new Socket(ip, puerto);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()), true);
            System.out.println("enviando...");
            salida.println("Nombre usuario: " + " " + "agrege su nombre aqui");
            System.out.println("recibiendo ... " + entrada.readLine());
            sk.close();
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }

}
