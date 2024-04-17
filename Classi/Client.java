package com.mycompany.comunicazione_unicast_tcp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Giacomo Contini
 *         14/03/2024
 */

public class Client {
  String nome;
  String colore;
  Socket socket;

  public Client(String nomeDefault, String coloreDefault) {
    this.nome = nomeDefault;
    this.colore = coloreDefault;
  }

  public void connetti(String nomeServer, int portaServer) {
    try {
      socket = new Socket(nomeServer, portaServer);
      System.out.println("Connesso al server " + nomeServer + " sulla porta " + portaServer);
    } catch (ConnectException ce) {
      System.err.println("Il server non è in ascolto " + ce.getMessage());
    }
    catch (UnknownHostException oh) {
      System.err.println("Errore durante la connessione al server: " + oh.getMessage());
    }
    catch (IOException e) {
      System.err.println("Impossibile connettersi al server: " + e.getMessage());
    }
  }

  public void scrivi(String messaggio) {
    try {
  socket.getOutputStream().write(messaggio.getBytes());
    } catch (IOException e) {
      System.err.println("Errore durante l'invio del messaggio: " + e.getMessage());
    }
  }

  public String leggi() {
    try {
      byte[] buffer = new byte[1024];
      int bytesRead = socket.getInputStream().read(buffer);
      return new String(buffer, 0, bytesRead);
    } catch (IOException e) {
      System.err.println("Errore durante la lettura del messaggio: " + e.getMessage());
      return null;
    }
  }

  public void chiudi() {
    try {
      socket.close();
    } catch (IOException e) {
      System.err.println("Errore durante la chiusura del socket: " + e.getMessage());
    }
  }
}