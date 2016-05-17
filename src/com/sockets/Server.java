package com.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private int port;
    private List<PrintStream> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<PrintStream>();
    }

    public void executa() throws IOException {
        // abertura de porta
        @SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(this.port);
        System.out.println("Porta " + this.port + " aberta!");

        while (true) {
            // aceita cliente e imprime cliente conectado
            Socket client = server.accept();
            System.out.println("Nova conexão com cliente "
                    + client.getInetAddress().getHostAddress());

            // adiciona saida do cliente a lista
            PrintStream ps = new PrintStream(client.getOutputStream());
            this.clients.add(ps);

            // cria tratador de cliente numa nova thread
            TrataClient tc = new TrataClient(client.getInputStream(), this);
            new Thread(tc).start();
        }
    }

    public void distribuiMensagem(String msg) {
        for (PrintStream cliente : this.clients){
            cliente.println(msg);
        }
    }
}
