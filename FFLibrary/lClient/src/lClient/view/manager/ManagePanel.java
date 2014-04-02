package lClient.view.manager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import lClient.biz.MyTableModel;
import common.CantFoundException;
import common.Variable;

public class ManagePanel extends JPanel implements ActionListener,Variable{

	//attributes
	private JButton addbt,deletebt,modifybt;
	private JButton find;
	private JPanel p1,p2,pcenter,jp1,jp2;
	private String bt1,bt2,bt3;
	private int manageThing;
	private JFrame parentF;
	private JButton findbt;
	private JTextField jtf ;
	private static int selectedId;
	private JRadioButton idBt;
	private JRadioButton nameBt;
	private JTable table=new JTable();
	private ManagePanel parentPanel;
	private String sqltb;
	private Vector colNames=new Vector();
	private String[] head=null;
	private int manageType;

	public ManagePanel(JFrame parentF,int manageThing){//i�����������ʲô
		this.setLayout(new BorderLayout());
		this.parentF=parentF;
		this.manageThing  =manageThing;
		manageType();
		
		addbt = new JButton(bt1);
		deletebt = new JButton(bt2);
		modifybt = new JButton(bt3);
		p1 = new JPanel();
		p1.add(addbt);
		p1.add(modifybt);
		p1.add(deletebt);
		this.add(p1, BorderLayout.SOUTH);
		
		p2 = new JPanel(new CardLayout());
		jp1 = new JPanel();
		p2.add("one", jp1);
		jp2 = new JPanel();
		p2.add("two",jp2);	
		
		Border border=BorderFactory.createEtchedBorder(Color.BLACK,Color.red);
		p2.setBorder(border);
		this.add(p2);
		
		addbt.addActionListener(this);
		deletebt.addActionListener(this);
		modifybt.addActionListener(this);
		
		
		if(manageThing == BOOK_MANAGE){
			sqltb="tb_book";
			head=BOOK_VARIABLES_LIST;
		}else if(manageThing == READER_MANAGE){
			sqltb="tb_reader";
			head=READER_VARIABLES_LIST;
		}else if(manageThing == RULE_MANAGE){
			sqltb="tb_rule";
			head=RULE_VARIABLES_LIST;
		}
		
//		colNames.removeAllElements();
//		for(int i=0;i<head.length;i++){
//			colNames.addElement(head[i]);
//		}
		
		p1 =new JPanel();
	    nameBt = new JRadioButton("名称");
	    nameBt.setSelected(true);
        idBt = new JRadioButton("编号");
		ButtonGroup group = new ButtonGroup();
		group.add(nameBt);
		group.add(idBt);
		p1.add(idBt);
		p1.add(nameBt);
		jtf = new JTextField(30);
		p1.add(jtf);
		findbt=new JButton("查找");
		p1.add(findbt);
		this.add(p1,BorderLayout.NORTH);
		
		findbt.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(int i){
				System.out.println("选中啦");
				if(table.getValueAt(table.getSelectedRow(),0)!=null) 
				selectedId=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				System.out.println("选中的id"+selectedId);
			}
		});
	}

	private void manageType() {
		// TODO Auto-generated method stub
		switch(manageThing){
		case 1:
			bt1 = "添加书籍";
			bt3 = "修改书籍";
			bt2 = "删除书籍";
			break;
		case 2:
			bt1 = "添加读者证";
			bt3 = "修改读者证";
			bt2 = "删除读者证";
			break;
		case 3:
			bt1 = "添加规则";
			bt3 = "修改规则";
			bt2 = "删除规则";
			break;
		default:
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addbt){
//			cleanTable();
//			table.repaint();
			if(manageThing==BOOK_MANAGE){
				new BookInfoFrame(this, ADD);
			}else if(manageThing==READER_MANAGE){
				new ReaderInfoFrame(this,ADD);
			}else if(manageThing==RULE_MANAGE){
				new RuleInfoFrame(this,ADD);
			}
			parentF.setVisible(false);
		}
		else if(e.getSource() == deletebt){
//			cleanTable();
			int res = JOptionPane.showConfirmDialog(this, "ȷ��ɾ��?","ȷ��ɾ��",JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION){
				delete();
			}
		}
		else if(e.getSource() == modifybt){
//			cleanTable();
//			table.repaint();
			this.parentF.setVisible(false);
			if(manageThing==BOOK_MANAGE)
				new BookInfoFrame(this,MODIFY);
			else if(manageThing==READER_MANAGE){
				new ReaderInfoFrame(this,MODIFY);
			}else if(manageThing==RULE_MANAGE){
				new RuleInfoFrame(this,MODIFY);
			}
		}
		else if(e.getSource()==findbt)
			find();
	}
	private void delete() {
		// TODO Auto-generated method stub
		String sqldelete="delete from "+sqltb+" where Id="+this.getSelectedId()+"";
	}

	public void FitTableColumns(JTable myTable){
		  JTableHeader header = myTable.getTableHeader();
		     int rowCount = myTable.getRowCount();
		     Enumeration columns = myTable.getColumnModel().getColumns();
		     while(columns.hasMoreElements()){
		         TableColumn column = (TableColumn)columns.nextElement();
		         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		         int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                 .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
		         for(int row = 0; row<rowCount; row++){
		             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		             width = Math.max(width, preferedWidth);
		         }
		         header.setResizingColumn(column); // ���к���Ҫ
		         column.setWidth(width+myTable.getIntercellSpacing().width);
		     }
	}
	public void find() {
		// TODO �ҵ�ָ�����鼮�ȱ�ɾ���޸�
		System.out.println("��ʼ��ѯ");
		String sql = null;
		String text = jtf.getText();
		if(nameBt.isSelected())
			sql ="select * from "+sqltb+" where Name like '%"+text+"%'";
		else
			sql = "select * from "+sqltb+" where Id ="+text+"";
		
		if(text.equals("")){
			JOptionPane.showMessageDialog(this, "��ѯ����Ϊ��");
			return;
		}
		else{
//			try {
//				table = new JTable(BookDAO.findInTable(sql),colNames);
//				} catch (CantFoundException e) {
//				e.printStackTrace();
//			}
			MyTableModel md=new MyTableModel(sql,head);
			table =new JTable(md);
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
			FitTableColumns(table);
			JScrollPane scroll = new JScrollPane(table);
			this.add(scroll);
			scroll.setVisible(true);
			table.setVisible(true);
		}
		
		jtf.setText("");
		selectedId = 0;
		String s;
	}

	/**
	 * @return the selectedId
	 */
	public int getSelectedId() {
		return selectedId;
	}
	
	public void cleanTable(){
		// ��ձ�
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		 for (int i = model.getRowCount() - 1; i >= 0; i--) {
           model.removeRow(i);
       } 
		 table.removeAll();
		 ((DefaultTableModel)table.getModel()).getDataVector().clear();
	}
	
	/**
	 * @return the parentF
	 */
	public JFrame getParentF() {
		return parentF;
	}
}