package com.sockets;

import java.io.InputStream;
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

        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}
