package ServerController;

import ClientController.InputReader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by andrzej on 27.06.17.
 */
public class Server {


	public static void main(String[] args) {

		int port = 4444;
//		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Started server on port " + port);
			ServerSocket serverSocket = new ServerSocket(port);

			Socket clientSocket = serverSocket.accept();

			InputReader inputReader = new InputReader(clientSocket.getInputStream());
			OutputReader outputReader = new OutputReader(clientSocket.getOutputStream());

			Thread inputReaderThread = new Thread(inputReader);
			Thread outputReaderThread = new Thread(outputReader);


			inputReaderThread.start();
			outputReaderThread.start();

//			System.out.println("Write something to client" + "\n");
//			String outToClient = scanner.nextLine();
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//			PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
//			printWriter.println(outToClient);
//
//
//			String response = reader.readLine();
//			System.out.println(response);
//
//			printWriter.close();
//			reader.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
