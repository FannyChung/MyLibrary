package lClient.srv;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSrvHelper {
	private Socket socket;
	private String host = "localhost";
	private int port = 8000;
	private ObjectInputStream fromServer;
	private ObjectOutputStream toServer;
	
	public ClientSrvHelper() {
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
