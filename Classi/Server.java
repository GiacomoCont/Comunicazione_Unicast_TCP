package com.mycompany.comunicazione_unicast_tcp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Giacomo Contini
 * 14/03/2024
 */

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
      if (serverSocket != null) {
        clientSocket = serverSocket.accept();
        System.out.println("Connessione accettata da: " + clientSocket.getInetAddress());
        return clientSocket;
      } else {
        return null;
      }
    } catch (BindException bi) {
      System.err.println("Porta già in uso o non disponibile: " + bi.getMessage());
      return null;
    } catch (IOException e) {
      System.err.println("Errore durante l'attesa della connessione: " + e.getMessage());
      return null;
    }
  }

  public void scrivi(String messaggio) {
    try {
clientSocket.getOutputStream().write(messaggio.getBytes());
    } catch (IOException e) {
      System.err.println("Errore durante l'invio del messaggio: " + e.getMessage());
    }
  }

  public String leggi() {
    try {
      byte[] buffer = new byte[1024];
      int bytesRead = clientSocket.getInputStream().read(buffer);
      return new String(buffer, 0, bytesRead);
    } catch (IOException e) {
      System.err.println("Errore durante la lettura del messaggio: " + e.getMessage());
      return null;
    }
  }

  public void chiudi() {
    try {
      clientSocket.close();
    } catch (IOException e) {
      System.err.println("Errore durante la chiusura della comunicazione con il client: " + e.getMessage());
    }
  }

  public void termina() {
    try {
      serverSocket.close();
    } catch (IOException e) {
      System.err.println("Errore durante la chiusura del server: " + e.getMessage());
    }
  }
}