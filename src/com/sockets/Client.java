package com.sockets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.Scanner;

public class Client {
	private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void executa() throws UnknownHostException, IOException {
        Socket client = new Socket(this.host, this.port);
        System.out.println("O cliente se conextou ao servidor: " + this.host);

        // thread para receber mensagens do servidor
        Receiver r = new Receiver(client.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner keyboard = new Scanner(System.in);
        PrintStream out = new PrintStream(client.getOutputStream());
        
        for(int i = 0; i < 3000; i++) {
        	out.println(LocalTime.now() + " - ");
        }
//        while (keyboard.hasNextLine()) {
//            out.println(LocalTime.now() + " - " +  keyboard.nextLine());
//        }

        out.close();
        keyboard.close();
        client.close();
    }
}
