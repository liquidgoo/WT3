package main.java.by.bsuir.wt.three.client;

import main.java.by.bsuir.wt.three.client.controller.ClientController;

public class Client {
    public static void main(String[] args) {
        ClientController client = new ClientController();
        client.start();
    }
}
