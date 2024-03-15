package com.mycompany.comunicazione_unicast_tcp;

/**
 *
 * @author Giacomo Contini
 * 14/03/2024
 */
public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(8080);
        server.attendi();
        server.scrivi("Ciao, sono il server!");
        System.out.println("Messaggio ricevuto dal client: " + server.leggi());
        server.chiudi();
    }
}