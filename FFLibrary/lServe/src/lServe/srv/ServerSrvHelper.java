package lServe.srv;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import common.AlreadyExistException;
import common.MessageType;
import common.ObjectTransformer;
import common.Variable.MessageStatusCode;
import common.beans.Book;
import common.beans.Message;
import common.dao.BookDao;

public class ServerSrvHelper implements Runnable {
	private int port = 8000;
	private Socket socket;
	private ObjectInputStream fromClient;
	private ObjectOutputStream toClient;
	
	public static void main(String[] args) {
		new ServerSrvHelper();
	}
	
	public ServerSrvHelper() {
	}

	public ServerSrvHelper(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				// �ӿͻ��˻��Message
				fromClient = new ObjectInputStream(socket.getInputStream());
				Message msg = ObjectTransformer.getMessage(fromClient.readObject());
				
				// ���������ؿͻ���
				Message msgRet = dealMessage(msg);
				toClient = new ObjectOutputStream(socket.getOutputStream());
				toClient.writeObject(msgRet);
			} catch (IOException e) {
				// TODO ����ͻ��˶Ͽ�����ν����߳�
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	private Message dealMessage(Message msg) {
		// TODO Auto-generated method stub
		Integer type = msg.getType(); 
		if(type.equals(MessageType.BOOK_ADD)){
			System.out.println("��ʼ��Bookת����Obj");
			Book book=ObjectTransformer.getBook(msg.getData());
			if(book==null){
				JOptionPane.showMessageDialog(null, "�����鼮ʧ��");
			}else{
				boolean addRs=false;
				
				try {
					System.out.println("���ԽӴ����ݿ�");
					addRs=BookDao.add(book);
				} catch (AlreadyExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//// ����Message
				Message msgRt=new Message();
				msgRt.setType(MessageType.BOOK_ADD);
				if(addRs){
					msgRt.setStatusCode(MessageStatusCode.SUCCESS);
					msgRt.setData(book);
				}else{
					msgRt.setStatusCode(MessageStatusCode.FAILED);
				}
				return msgRt;
			}
		}
		return null;
	}
}
