

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws IOException {

		Socket client = new Socket("127.0.0.1", 4444);

		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

		System.out.println("Echo Client Started");

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		String line = stdIn.readLine();

		while (line != null) {

			out.println(line);

			System.out.println("Echo: " + in.readLine());

			if ("Bye".equals(line)) {
				break;
			}
			line = stdIn.readLine();
		}
		out.close();
		in.close();
		stdIn.close();
		client.close();
	}
}
