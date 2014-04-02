package lClient.srv;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import common.ObjectTransformer;
import common.beans.Book;
import common.beans.Message;
import common.beans.Reader;

public class ClientSrvReaderHelper {
	private Socket socket;
	private String host = "localhost";
	private int port = 8000;
	private ObjectInputStream fromServer;
	private ObjectOutputStream toServer;
	
	public ClientSrvReaderHelper() {
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
	
	public Reader addReader(Reader reader){
		Message msgaddReader=Message.addReaderMessage(reader);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgaddReader);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getReader(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Reader modifyReader(Reader reader){
		Message msgaddReader=Message.modifyReaderMessage(reader);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgaddReader);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getReader(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Reader deleteReader(Reader reader){
		Message msgaddReader=Message.deleteReaderMessage(reader);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgaddReader);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getReader(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
