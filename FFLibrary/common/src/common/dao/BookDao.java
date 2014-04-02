package common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;




import common.AlreadyExistException;
import common.CantFoundException;
import common.beans.Book;

/**
 * @author zhongfang
 *
 */
public class BookDao {
	private static Connection conn=null;
	private static Statement state=null;
	private static ResultSet rs=null;
	private static String title,author,type,callCode,publisher,publishTime,enterTime,status,descrip,storePlace;
	private static int bookId;
	private static double price;
	
	private static String DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static String CONN_URL = "jdbc:odbc://localhost/campusInfo";
	private static String USER_NAME = "goclis";
	private static String PASSWORD = "qqqqqq";

	public static void initialize(){
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONN_URL,USER_NAME,PASSWORD);
			state=conn.createStatement();
			System.out.println("连接到了数据库");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//创建表Book
	public static void createBookTable(){
		initialize();

		try {
			state.executeUpdate("drop table tb_book");
			System.out.println("成功删除表");
			String create  = "create table tb_book (ID integer primary key, Name char(40), "
					+ "Author char(20),Type char(30),CallCode char(30), StorePlace char(40),"
					+ "Publisher char(20),PublishTime char(20),EnterTime char(20),"
					+ "Price double,Status char(10),Description char(100)";
			state.executeUpdate(create);
			System.out.println("成功创建表");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		terminate();
		}
	public static void terminate(){
		if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		}
		if(state!=null)
		try {
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn!=null)
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("成功关闭资源");
	}
	public static boolean add(Book book) throws AlreadyExistException, SQLException{
		String sql;
		bookId=book.getBookId();
		
		initialize();
		sql="select * from tb_book where Id="+bookId+"";
		rs=state.executeQuery(sql);
		terminate();

		if(rs.next())
			return false;
		else{
			initialize();
			System.out.println("开始添加");
			title=book.getTitle();
			author=book.getAuthor();
			type = book.getType();
			callCode=book.getCallCode();
			storePlace=book.getStorePlace();
			publisher=book.getPublisher();
			publishTime=book.getPublishTime();
			enterTime =book.getEnterTime();
			price =book.getPrice();
			status=book.getStatus();
			descrip=book.getDescription();
			
			sql="insert into tb_book values("+bookId+",'"+title+"',"
							+ "'"+author+"','"+type+"','"+callCode+"','"+storePlace+"','"+publisher+"',"
									+ "'"+publishTime+"','"+enterTime+"',"+price+",'"+status+"',"
											+ "'"+descrip+"')";
				int r=state.executeUpdate(sql);
				terminate();
				return true;
		}
		
	}
	public static void update(Book book){
		bookId=book.getBookId();

		try {
			Book b=getBook(bookId);
			title=book.getTitle();
			author=book.getAuthor();
			type = book.getType();
			callCode=book.getCallCode();
			publisher=book.getPublisher();
			publishTime=book.getPublishTime();
			status=book.getStatus();
			price =book.getPrice();
			descrip=book.getDescription();
			
			String sqldelete ="update tb_book set Title='"+title+"', Author='"+author+"',"
					+ " Type='"+type+"', CallCode='"+callCode+"', Publiser='"+publisher+"',"
							+ "PublishTime='"+publishTime+"',Status='"+status+"',"
									+ "Price="+price+",Description='"+descrip+"'";
			int r=state.executeUpdate(sqldelete);
		} catch (CantFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void delete(String sql){
//		int id=book.getBookId();
//		try {
//			Book b=getBook(id);
//			String sqldelete ="delete from tb_book where Id="+id+"";
//			int r=state.executeUpdate(sqldelete);
//			JOptionPane.showMessageDialog(null, "�ɹ�ɾ���鼮");
//		} catch (CantFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "���鼮������");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		initialize();
		try {
			int r=state.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "�ɹ�ɾ���鼮");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminate();
	}
	public static Vector findInTable(String sql) throws CantFoundException{
		Vector v=new Vector(1);
		Vector wv=new Vector(1);
		System.out.println("����DAO��ѯ");
		wv.removeAllElements();
		initialize();
		rs=null;
		try {
			rs=state.executeQuery(sql);
			if(rs!=null){
			while(rs.next()){
				System.out.println("find it!");
				v.removeAllElements();
				v.addElement(rs.getInt(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				v.addElement(rs.getString(8));
				v.addElement(rs.getDouble(9));
				v.addElement(rs.getString(10));
				v.addElement(rs.getString(11));
//				v.addElement(rs.getString(12));//�ݲص�
				wv.addElement(v);
			}
			}
			else
				JOptionPane.showMessageDialog(null, "�Ҳ������鼮");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminate();
		return wv;
	}
	
	
	public static Book getBook(int id) throws CantFoundException{
		initialize();
		String sql="select * from tb_book where Id="+id+"";
		Book book=null;
		try {
			rs=state.executeQuery(sql);
			System.out.println("find it!");
			if(rs.next()){
				title=rs.getString(2);
				author=rs.getString(3);
				type=rs.getString(4);
				callCode=rs.getString(5);
				publisher=rs.getString(6);
				publishTime=rs.getString(7);
				enterTime=rs.getString(8);
				price=rs.getDouble(9);
				status=rs.getString(10);
				descrip=rs.getString(11);
				storePlace=rs.getString(12);
			}else{
				throw(new CantFoundException("找不到该书籍"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminate();
		book=new Book(id,title,author,type,callCode,publisher,publishTime,price, storePlace);
		return book;
	}
	
	public static void main(String[] args){
		createBookTable();
	}
}


