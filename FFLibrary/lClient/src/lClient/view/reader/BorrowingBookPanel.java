/**
 * 
 */
package lClient.view.reader;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author zhongfang
 *
 */
public class BorrowingBookPanel extends JPanel {

	private JTable table;
	private JButton returnbt,lostbt;
	private JPanel p1,p2;
	private JScrollPane scroll;
	
	public BorrowingBookPanel(){
		this.setLayout(new BorderLayout());
		table = new JTable(10,8);
		scroll = new JScrollPane(table);
		this.add(scroll);

		returnbt = new JButton("ªπ È");
		lostbt = new JButton("π“ ß");
		p1 = new JPanel(new FlowLayout());
		p1.add(returnbt);
		p1.add(lostbt);
		this.add(p1,BorderLayout.SOUTH);
	}
}
