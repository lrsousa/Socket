package com.sockets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class Receiver implements Runnable {
    private InputStream server;

    public Receiver(InputStream server) {
        this.server = server;
    }

    @Override
    public void run() {
        @SuppressWarnings("resource")
		Scanner s = new Scanner(this.server);
        
        FileWriter leituras = null;
		try {
			leituras = new FileWriter("leituras.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrintWriter escrever = new PrintWriter(leituras);
        
        while (s.hasNextLine()) {
        	escrever.println("Hora envio: " + s.nextLine() + "Hora recebimento: " + LocalTime.now());
//            System.out.println("Hora envio: " + s.nextLine() + "Hora recebimento: " + LocalTime.now());
        }
    }
}
