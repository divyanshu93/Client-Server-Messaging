import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {

	String ip;
	int port;

	public Client(String ip, int port) {

		this.ip = ip;
		this.port = port;

	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {

			try {
				Socket s = new Socket(ip, port);
				OutputStream output = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(output);
				Message m = new Message(String.valueOf(i));
				oos.writeObject(m);
				output.close();
				s.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
