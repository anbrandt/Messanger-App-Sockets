package ClientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by andrzej on 27.06.17.
 */
public class InputReader implements Runnable {
	//input reader reads the message from client in server (im the server)

	private final BufferedReader bufferedReader;

	public InputReader(final InputStream inputStream) {
		this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	}

	public void run() {
		while(true) {
			try {
				String answer = bufferedReader.readLine();
				System.out.println(answer);

			} catch (IOException e) {
			System.err.println(e);//print in red lines
			}
		}

	}
}
