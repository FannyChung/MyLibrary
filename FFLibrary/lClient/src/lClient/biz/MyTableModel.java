/**
 * ����JTable�����ݿ�֮��Ľ���
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
	Vector<Vector<String>> rowData = new Vector<Vector<String>>(); //����һ����ά����
	String[] columnNames; //��һ�������ű������
	
	
	//��ѯ����ʱʹ�õĹ��췽����
	public MyTableModel(String sql,String[] columnNames){
		this.columnNames = columnNames;
		getQuery(sql);
	}
	
//	//�½���
//	public void createBookTable(){
//		
//		try {
//			openDB();
//			ps.executeUpdate("drop table tb_book");
//			System.out.println("�ɹ�ɾ����");
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
	//�Ӳ�ѯ�����Ľ�����л�ȡ���ݣ����ö�ά��
	public void setRowData(){
		if(rs != null){
			System.out.print("�ҵ���");
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
			JOptionPane.showMessageDialog(null, "�Ҳ���");
			System.out.print("�Ҳ���");
		}
	}
	
	//�����ݿ�
	public void openDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:campusInfo");
			state=conn.createStatement();
			System.out.println("�ɹ������ݿ�");
		} catch (Exception e) {
			System.out.print("�������ݿ�������������ݿ������û��������");
			e.printStackTrace();
		}
	}
	
	//�ر����ݿ�
	public void closeDB(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.print("�ر����ݿ����");
//				e.printStackTrace();
			}
		}
//		if(ps != null){
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				System.out.print("�ر����ݿ����");
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
				System.out.print("�ر����ӳ���");
//				e.printStackTrace();
			}
		}
		System.out.println("�ɹ��ر����ݿ�");
	}
	
	//����sql��ѯ
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
	
	//��д����  ��ʾ����
	public int getColumnCount() {
		
		return columnNames.length;
	}

	//��д�������������������ʾ������
	public String getColumnName(int i) {
		// TODO Auto-generated method stub
		return columnNames[i];
	}
	
	//��д��������ʾ����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	//��д��������ʾ��ѯ���Ķ�ά������
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


