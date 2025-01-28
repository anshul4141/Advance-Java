package com.rays.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(1234);

		Socket client = server.accept();

		DataInputStream in = new DataInputStream(client.getInputStream());

		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		String line = in.readLine();

		System.out.println(line);

		out.writeBytes("Hello Client\n");

		client.close();

		server.close();

	}
}