/**
 * 用于JTable和数据库之间的交互
 */
package lClient.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * @author zhongfang
 *
 */
public class MyTableModel extends AbstractTableModel{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement state;
	Vector<Vector<String>> rowData = new Vector<Vector<String>>(); //类似一个二维数组
	String[] columnNames; //用一个数组存放表的列名
	
	
	//查询数据时使用的构造方法。
	public MyTableModel(String sql,String[] columnNames){
		this.columnNames = columnNames;
		getQuery(sql);
	}
	
//	//新建表
//	public void createBookTable(){
//		
//		try {
//			openDB();
//			ps.executeUpdate("drop table tb_book");
//			System.out.println("成功删除表");
//			String create  = "create table tb_book (BookId integer, Title char(40), Author char(20))";
//			ps.executeUpdate(create);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		closeDB();
//	}
//	
	//从查询出来的结果集中获取数据，设置二维表
	public void setRowData(){
		if(rs != null){
			System.out.print("找到了");
			try{
				while(rs.next()){
					Vector<String> temp = new Vector<String>();
					for(int i=0;i<rs.getMetaData().getColumnCount();i++){
						temp.add(new String(rs.getString(i+1)));
					}
					rowData.add(temp);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "找不到");
			System.out.print("找不到");
		}
	}
	
	//打开数据库
	public void openDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
			state=conn.createStatement();
			System.out.println("成功打开数据库");
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
//				e.printStackTrace();
			}
		}
//		if(ps != null){
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				System.out.print("关闭数据库出错！");
//			}
//		}
		if(state!=null)
			try {
				state.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.print("关闭连接出错！");
//				e.printStackTrace();
			}
		}
		System.out.println("成功关闭数据库");
	}
	
	//用于sql查询
	public ResultSet getQuery(String sql){
		rs=null;
		try {
			openDB();
//			ps = conn.prepareStatement(sql);        
//			rs = ps.executeQuery();
			rs=state.executeQuery(sql);
			setRowData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return rs;
	}
	
	//重写方法  显示列数
	public int getColumnCount() {
		
		return columnNames.length;
	}

	//重写的这个方法用于设置显示的列名
	public String getColumnName(int i) {
		// TODO Auto-generated method stub
		return columnNames[i];
	}
	
	//重写方法，显示行数
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	//重写方法，显示查询到的二维表数据
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return rowData.get(arg0).get(arg1);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public TableModelListener[] getTableModelListeners() {
//		// TODO Auto-generated method stub
//		return super.getTableModelListeners();
//	}
//
//	@Override
//	public boolean isCellEditable(int arg0, int arg1) {
//		// TODO Auto-generated method stub
//		return super.isCellEditable(arg0, arg1);
//	}
//
//	@Override
//	public void setValueAt(Object arg0, int arg1, int arg2) {
//		// TODO Auto-generated method stub
//		super.setValueAt(arg0, arg1, arg2);
//	}

}


