/**
 * 
 */
package lClient.view.reader;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import common.Variable;

/**
 * @author zhongfang
 *
 */
public class FindBookPanel extends JPanel implements ActionListener,Variable{

	//attributes
	private JRadioButton searchbt,classbt;
	private JComboBox type;
	private JTextField key;
	private JButton findbt;
	private JTable table;
	private JPanel jp1,jp2,jpin1,jpin2,jp3,jpcenter,byKeyPanel,byClassPanel,lowJp;
	private ReaderLibraryFrame parentF;
	private JButton orderBt,borrowBt;
	private String sql;
	private JButton next;
	private JList bookTypeList;
	
	/**
	 * 建立查询书籍的面板
	 */
	public FindBookPanel() {
		// TODO
		this.setLayout(new BorderLayout());
		
		jp1 = new JPanel();
		searchbt = new JRadioButton("search by key words");
		classbt = new JRadioButton("search by class");
		ButtonGroup goup = new ButtonGroup();
		goup.add(searchbt);
		goup.add(classbt);
		jp1.add(searchbt);
		jp1.add(classbt);
		this.add(jp1,BorderLayout.NORTH);
		
		lowJp = new JPanel();
		borrowBt = new JButton("借书");
		orderBt = new JButton("预约");
		lowJp.add(borrowBt);
		lowJp.add(orderBt);
		this.add(lowJp,BorderLayout.SOUTH);
		
		jpcenter = new JPanel(new CardLayout());
		Border border=BorderFactory.createEtchedBorder(Color.BLACK,Color.red);
		jpcenter.setBorder(border);

		next = new JButton("下一页");

		JComboBox com = new JComboBox(BOOK_VARIABLES_LIST);
		JTextField txt = new JTextField(50);
		findbt = new JButton("查询");
		jpin1 = new JPanel(new FlowLayout());
		jpin1.add(com);
		jpin1.add(txt);
		jpin1.add(findbt);
		jp2 = new JPanel(new FlowLayout());
		jp2.add(jpin1);
		table = new JTable(6,9);
		jp2.add(table);
		jp2.add(next);


//		jpin2 = new JPanel(new GridLayout(6,5));
//		for(int i= 0;i<BOOK_TYPE_LIST.length;i++){
//			JRadioButton rb = new JRadioButton(BOOK_TYPE_LIST[i]);
//			jpin2.add(rb);
//		}
		jpin2 = new JPanel();
		bookTypeList = new JList(BOOK_TYPE_LIST);
		jpin2.add(bookTypeList);
		
		jp3= new JPanel(new FlowLayout());
		jp3.add(jpin2);
		JTable table2= new JTable(6,9);
		jp3.add(table2);
		jp3.add(next,BorderLayout.SOUTH);
		
		jpcenter.add(jp2,"one");
		jpcenter.add(jp3,"two");
		
		this.add(jpcenter);
		
		searchbt.addActionListener(this);
		classbt.addActionListener(this);
		
		borrowBt.addActionListener(this);
		orderBt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == searchbt)
		{	searchbyWord();
		}
		else if(arg0.getSource() == classbt)
			searchbyClass();
		else if(arg0.getSource() == borrowBt)
			borrowBook();
		else if(arg0.getSource() == orderBt)
			orderBook();
	}

	private void orderBook() {
		// TODO Auto-generated method stub
	}

	private void borrowBook() {
		// TODO Auto-generated method stub
		
	}

	private void searchbyClass() {
		// TODO 按类别查询书籍
//		String type = "";
//		String sqlfind= "select from tblBook where ";
//		MyTableModel tm = new MyTableModel(sql, null);
//		table = new JTable(tm);
//		jp3.add(table);
		
		((CardLayout)jpcenter.getLayout()).show(jpcenter, "two");

	}
	
	private void searchbyWord(){
		
		((CardLayout)jpcenter.getLayout()).show(jpcenter, "one");
	}

}
