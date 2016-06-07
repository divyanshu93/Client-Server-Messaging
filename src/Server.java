import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(34533);

			// Thread.sleep(3000);

			// Client c = new Client("localhost", 34533);
			// c.start();

			while (true) {

				Socket clientSocket = s.accept();
				InputStream input = clientSocket.getInputStream();
				ObjectInputStream oinput = new ObjectInputStream(input);

				Message m = (Message) oinput.readObject();

				System.out.println("I received:" + m.s + " from client");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
