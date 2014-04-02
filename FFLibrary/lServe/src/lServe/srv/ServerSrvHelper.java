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
				// 从客户端获得Message
				fromClient = new ObjectInputStream(socket.getInputStream());
				Message msg = ObjectTransformer.getMessage(fromClient.readObject());
				
				// 将反馈发回客户端
				Message msgRet = dealMessage(msg);
				toClient = new ObjectOutputStream(socket.getOutputStream());
				toClient.writeObject(msgRet);
			} catch (IOException e) {
				// TODO 处理客户端断开后，如何结束线程
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
			System.out.println("开始摆Book转换成Obj");
			Book book=ObjectTransformer.getBook(msg.getData());
			if(book==null){
				JOptionPane.showMessageDialog(null, "增加书籍失败");
			}else{
				boolean addRs=false;
				
				try {
					System.out.println("尝试接触数据库");
					addRs=BookDao.add(book);
				} catch (AlreadyExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//// 反馈Message
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
