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
	
	Vector<Vector<String>> rowData = new Vector<Vector<String>>(1); //����һ����ά����
	String[] columnNames; //��һ�������ű������
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
			System.out.println("�ɹ������ݿ�");
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
			System.out.println("�ر�ResultSet����");
		}
		}
		if(state!=null){
		try {
			state.close();
		} catch (SQLException e) {
			System.out.println("�ر�Statement����");
		}
		}
		if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("�ر�Connection����");
		}
		}
		System.out.println("�ɹ��ر����ݿ�");
	}
	
	//��ѯ
	public void getQuery(String sql){
		openDB();
		try {
			rs= state.executeQuery(sql);
			if(rs!=null)
			setRowData(rs);
			else
				JOptionPane.showMessageDialog(null, "������");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			closeDB();
		}
	}
	
	//����SQL��,ɾ,��
	public int executeUpdate(String sql,Object[] objects){
		//TODO ��ѯ���ݿ�
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
			JOptionPane.showMessageDialog(null, "�����ɹ���");
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
					System.out.println("�ҵ���"+rs.getString(1));
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
