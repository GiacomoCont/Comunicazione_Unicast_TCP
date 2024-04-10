package com.mycompany.comunicazione_unicast_tcp;

/**
 *
 * @author Giacomo Contini
 *         14/03/2024
 */
public class MainClient {

  public static void main(String[] args) {
    Client client = new Client("Jack", "Blue");
    client.connetti("localhost", 2005);
    client.scrivi("Ciao, sono il client!");
    System.out.println("Messaggio ricevuto dal server: " + client.leggi());
    client.chiudi();
  }
}