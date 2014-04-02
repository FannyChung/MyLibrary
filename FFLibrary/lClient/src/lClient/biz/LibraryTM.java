/**
 * 
 */
package lClient.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author zhongfang
 *
 */
public class LibraryTM extends DefaultTableModel{

	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Vector<Vector> wv=new Vector<Vector>(1);
	Vector nv=new Vector();
	String[] colNames;
	/**
	 * 
	 */
	public LibraryTM(String sql,String[] colNames) {
		// TODO Auto-generated constructor stub
		
		this.colNames=colNames;
		for(int i=0;i<colNames.length;i++)
			this.addColumn(colNames[i]);
	}
//
//	public void getQuery(String sql){
//		openDB();
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			if(rs==null)
//				JOptionPane.showMessageDialog(null, "没找到");
//			else
//				setData(rs);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally{
//			closeDB();
//		}
//	}
	private void setData(Vector wv) {
		// TODO Auto-generated method stub
//		try {
//			wv.removeAllElements();				
//			nv.removeAllElements();
//			while(rs.next()){
//				System.out.println("找到");
//				for(int i=0;i<rs.getMetaData().getColumnCount();i++){
//					nv.addElement(rs.getObject(i+1).toString());
//				}
//				wv.addElement(nv);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	//打开数据库
	public void openDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
		} catch (Exception e) {
			System.out.print("连接数据库出错，可能是数据库服务器没有启动！");
			e.printStackTrace();
		}
	}
	
	//关闭数据库
	public void closeDB(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.print("关闭数据库出错！");
//					e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.print("关闭数据库出错！");
//					e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.print("关闭连接出错！");
//					e.printStackTrace();
			}
		}
	}
		

}
