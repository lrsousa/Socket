package com.sockets;

import java.io.IOException;

public class ServerApp {
	public static void main(String[] args) throws IOException {
		new Server(4444).executa();
	 }
}
