/**
 * 
 */
package lClient.srv;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import common.ObjectTransformer;
import common.beans.Book;
import common.beans.Message;

/**
 * @author zhongfang
 *
 */
public class ClientSrvBookHelper{

	private Socket socket;
	private String host = "localhost";
	private int port = 8000;
	private ObjectInputStream fromServer;
	private ObjectOutputStream toServer;
	
	public ClientSrvBookHelper() {
		try {
			socket = new Socket(host, port);
			System.out.println("socket 创建成功");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Book addBook(Book book){
		
		Message msgaddBook=Message.addBookMessage(book);
		System.out.println("设置好了Message");
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgaddBook);
			toServer.flush();
			System.out.println("发送给了客户端");
			//TODO 避免发生Connection reset
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			System.out.println("从客户端取得返回");
			return ObjectTransformer.getBook(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Book deleteBook(Book book){
		Message msgdeleteBook=Message.deleteBookMessage(book);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgdeleteBook);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getBook(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Book modifyBook(Book book){
		Message msgdeleteBook=Message.modifyBookMessage(book);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgdeleteBook);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getBook(msgBack.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getBook(Book book){
		Message msgBook=Message.findBookMessage(book);
		try {
			toServer=new ObjectOutputStream(socket.getOutputStream());
			toServer.writeObject(msgBook);
			toServer.flush();
			
			fromServer=new ObjectInputStream(socket.getInputStream());
			Message msgBack=ObjectTransformer.getMessage(fromServer.readObject());
			
			return ObjectTransformer.getBook(msgBack.getData());
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
