package com.rays.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLReader {

	public static void main(String[] args) {

		URL u = null;

		try {
			u = new URL("https://www.raystdgdfgfgec.com/tutorials.html");

			System.out.println("Protocol: " + u.getProtocol());
			System.out.println("Host Name: " + u.getHost());
			System.out.println("Port Number: " + u.getPort());
			System.out.println("File Name: " + u.getFile());

			InputStream iStr = u.openStream();

			Scanner in = new Scanner(iStr);

			System.out.print("URL contents ***");

			while (in.hasNext()) {
				String html = in.nextLine();
				System.out.println(html);
			}

			in.close();

		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		} catch (IOException e) {
			System.out.println("Input Output Error");
		}
	}

}