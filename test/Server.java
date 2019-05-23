import java.net.*;
import java.io.*;

public class Server {
	public static void main(String args[]) throws Exception {

		ServerSocket serverSocket = new ServerSocket(3000);

		while(true) {
			Socket socket = serverSocket.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("address.txt")));
			PrintStream out = new PrintStream(socket.getOutputStream());

			String data="";

			while((data=in.readLine())!=null)
				out.println(data);

			socket.close();
		}
	}
}
