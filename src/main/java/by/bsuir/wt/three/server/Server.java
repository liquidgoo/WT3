package main.java.by.bsuir.wt.three.server;

import main.java.by.bsuir.wt.three.server.controller.ServerController;

public class Server {
    public static void main(String[] args) {
        var server = new ServerController();
        server.start();
    }
}
