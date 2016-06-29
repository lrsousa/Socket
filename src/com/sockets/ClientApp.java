package com.sockets;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientApp {
	 public static void main(String[] args) throws UnknownHostException, IOException {
		 new Client("localhost", 8080).executa();
		 
	 }
}
