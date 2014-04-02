

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import lServe.srv.ServerSrvHelper;

/**
 * 
 * @author zhongfang
 *
 */
public class Server {
	private int port = 8000;
	
	// threads ����Ϊÿ���ͻ������������߳�
	private HashMap<Long, ServerSrvHelper> threads; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server Start");
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new ServerSrvHelper(socket)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
