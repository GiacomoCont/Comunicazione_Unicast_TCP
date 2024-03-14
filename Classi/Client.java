package com.mycompany.comunicazione_unicast_tcp;

/**
 *
 * @author Giacomo Contini
 * 14/03/2024
 */
public class Client {
    String nome;
    String colore;
    
    public Client(String nomeDefault, String coloreDefault) {
        this.nome = nomeDefault;
        this.colore = coloreDefault;
    }
    
    public void connetti(String nomeServer, int importaServer) {
        System.out.println("Hello World!");
    }
    
    public void scrivi() {
        System.out.println("Hello World!");
    }
    
    public void leggi() {
        System.out.println("Hello World!");
    }
    
    public void chiudi() {
        System.out.println("Hello World!");
    }
}
