package ClientController;

import ServerController.OutputReader;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by andrzej on 27.06.17.
 */
public class Client {

	public static void main(String[] args) {

		String serverHost = "localhost";
		int port = 4444;
//		Scanner scanner = new Scanner(System.in);

		try {

			Socket socket = new Socket(serverHost, port);

			InputReader inputReader = new InputReader(socket.getInputStream());
			OutputReader outputReader = new OutputReader(socket.getOutputStream());

			Thread inputReaderThread = new Thread(inputReader);
			Thread outputReaderThread = new Thread(outputReader);

			inputReaderThread.start();
			outputReaderThread.start();

//
//
//
//			System.out.println("Welcome to Client. You are connected to " + port);
//
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String inputFromServer = reader.readLine();
//
//			System.out.println("Server said: "+ inputFromServer);
//
//
//			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//
//			System.out.println("Write something to server" + "\n");
//			String outToServer = scanner.nextLine();
//			printWriter.print(outToServer);
//
//			printWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
