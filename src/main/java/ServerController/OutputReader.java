package ServerController;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by andrzej on 27.06.17.
 */
public class OutputReader implements Runnable {
	//output reader sends the message from server (from me) to client

	private final PrintWriter printWriter;
	private final Scanner scanner;

	public OutputReader(final OutputStream outputstream) {
		this.printWriter = new PrintWriter(outputstream, true);
		this.scanner = new Scanner(System.in);
	}

	public void run() {
		while(true) {
			String nextLine = scanner.nextLine();
		//	System.out.println(nextLine);
			printWriter.println(nextLine);
			printWriter.flush();
		}


	}
}
