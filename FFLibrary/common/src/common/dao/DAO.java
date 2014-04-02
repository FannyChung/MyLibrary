package common.dao;
/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author C5115
 *
 */
public class DAO {

	protected static String  dbClassName = "sun.jdbc.odbc.JdbcOdbcDriver";
	protected static String dbUrl = "jdbc:odbc://localhost/campusInfo";
	protected static String dbUser ="goclis";
	protected static String dbPwd = "qqqqqq";
	protected static String second = null;
	public static Connection conn=null;
	private static ResultSet rs=null;
	private static PreparedStatement ps;
	private static Statement state;
	public static Connection initialize(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
		} catch (Exception e) {
			System.out.print("�������ݿ�������������ݿ������û��������");
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ�
		public static void terminate(){
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.print("�ر����ӳ���");
//					e.printStackTrace();
				}
			}
		}
		public static void openDB() {
			// TODO Auto-generated method stub
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
				state=conn.createStatement();
				System.out.println("�ɹ������ݿ�");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void closeDB(){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
//					e.printStackTrace();
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
				System.out.println("�ɹ��ر����ݿ�");
		}
		
}