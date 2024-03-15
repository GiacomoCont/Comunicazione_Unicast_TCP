package com.mycompany.comunicazione_unicast_tcp;

/**
 *
 * @author Giacomo Contini
 * 14/03/2024
 */

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int porta;

    public Server(int porta) {
        this.porta = porta;
    }

    public Socket attendi() {
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in attesa sulla porta " + porta);
            clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata da: " + clientSocket.getInetAddress());
            return clientSocket;
        } catch (Exception e) {
            System.err.println("Errore durante l'attesa della connessione: " + e.getMessage());
            return null;
        }
    }

    public void scrivi(String messaggio) {
        try {
            clientSocket.getOutputStream().write(messaggio.getBytes());
        } catch (Exception e) {
            System.err.println("Errore durante l'invio del messaggio: " + e.getMessage());
        }
    }

    public String leggi() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            return new String(buffer, 0, bytesRead);
        } catch (Exception e) {
            System.err.println("Errore durante la lettura del messaggio: " + e.getMessage());
            return null;
        }
    }

    public void chiudi() {
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Errore durante la chiusura del server: " + e.getMessage());
        }
    }

    public void termina() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Errore durante la chiusura del server: " + e.getMessage());
        }
    }
}