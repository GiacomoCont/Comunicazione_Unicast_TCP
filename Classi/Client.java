package com.mycompany.comunicazione_unicast_tcp;

import java.net.Socket;

/**
 *
 * @author Giacomo Contini
 * 14/03/2024
 */

public class Client {
    String nome;
    String colore;
    private Socket socket;

    public Client(String nomeDefault, String coloreDefault) {
        this.nome = nomeDefault;
        this.colore = coloreDefault;
    }

    public void connetti(String nomeServer, int importaServer) {
        try {
            socket = new Socket(nomeServer, importaServer);
            System.out.println("Connesso al server " + nomeServer + " sulla porta " + importaServer);
        } catch (Exception e) {
            System.err.println("Impossibile connettersi al server: " + e.getMessage());
        }
    }

    public void scrivi(String messaggio) {
        try {
            socket.getOutputStream().write(messaggio.getBytes());
        } catch (Exception e) {
            System.err.println("Errore durante l'invio del messaggio: " + e.getMessage());
        }
    }

    public String leggi() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            return new String(buffer, 0, bytesRead);
        } catch (Exception e) {
            System.err.println("Errore durante la lettura del messaggio: " + e.getMessage());
            return null;
        }
    }

    public void chiudi() {
        try {
            socket.close();
        } catch (Exception e) {
            System.err.println("Errore durante la chiusura del socket: " + e.getMessage());
        }
    }
}