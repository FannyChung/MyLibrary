/**
 * 
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
import javax.swing.table.DefaultTableModel;

/**
 * @author zhongfang
 *
 */
public class MTableModel extends DefaultTableModel{

	private Connection conn=null;
	private PreparedStatement ps=null;
	private Statement state=null;
	private ResultSet rs=null;
	
	Vector<Vector<String>> rowData = new Vector<Vector<String>>(1); //类似一个二维数组
	String[] columnNames; //用一个数组存放表的列名
	/**
	 * 
	 */
	public MTableModel(String sql,String[] columnNames) {
		// TODO Auto-generated constructor stub
		rs=null;
		this.columnNames =columnNames;
		for(int i=0;i<columnNames.length;i++)
		this.addColumn(columnNames[i]);
		this.getQuery(sql);
		
	}

	public void openDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
			state=conn.createStatement();
			System.out.println("成功打开数据库");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeDB(){
		if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("关闭ResultSet出错");
		}
		}
		if(state!=null){
		try {
			state.close();
		} catch (SQLException e) {
			System.out.println("关闭Statement出错");
		}
		}
		if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("关闭Connection出错");
		}
		}
		System.out.println("成功关闭数据库");
	}
	
	//查询
	public void getQuery(String sql){
		openDB();
		try {
			rs= state.executeQuery(sql);
			if(rs!=null)
			setRowData(rs);
			else
				JOptionPane.showMessageDialog(null, "不存在");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			closeDB();
		}
	}
	
	//用于SQL增,删,改
	public int executeUpdate(String sql,Object[] objects){
		//TODO 查询数据库
		int num=0;
		openDB();
		try {
			ps= conn.prepareStatement(sql);
			if (objects!=null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i+1,objects[i]);
				}
			}
			num=ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return num;
	}
	
	public void setRowData(ResultSet rs){
		if(rs != null){
			try{
				while(rs.next()){
					System.out.println("找到："+rs.getString(1));
					Vector temp = new Vector();
					for(int i=0;i<rs.getMetaData().getColumnCount();i++){
						if(rs.getObject(i+1)==null)
							temp.add("");
						else
//						temp.add(new String((String) rs.getObject(i+1)));
							temp.add(new String (rs.getString(i+1)));
					}
					rowData.add(temp);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

//	@Override
//	public int getRowCount() {
//		// TODO Auto-generated method stub
//		return rowData.size();
//	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return rowData.get(arg0).get(arg1);
	}
}
