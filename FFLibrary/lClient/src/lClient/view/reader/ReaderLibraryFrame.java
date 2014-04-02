/**
 * 
 */
package lClient.view.reader;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author zhongfang
 *
 */
public class ReaderLibraryFrame extends JFrame implements ActionListener,ChangeListener{

	//attributes
	private Container c;
	private JPanel jp1,jp2;
	private FindBookPanel findbookp;
	private JTabbedPane tabbedp;

	//TODO:����ͼ��ݵ���ҳ��
	public ReaderLibraryFrame(){
		c = this.getContentPane();
//		c.setLayout(new BorderLayout());
		
		Border border=BorderFactory.createEtchedBorder(Color.BLACK,Color.blue);
		jp1 = new JPanel();
		jp1.setBorder(border);
		
		tabbedp = new JTabbedPane(JTabbedPane.LEFT);
		tabbedp.addChangeListener(this);
		tabbedp.addTab("��ѯ�鼮",new FindBookPanel());
		tabbedp.addTab("ӵ���鼮", new BorrowingBookPanel());
		tabbedp.addTab("������ʷ", new JTable(6,9));
//		tabbedp.addTab("�ҵ�ԤԼ", new OrderBookPanel());
		tabbedp.addTab("�ɷ��嵥", new JTable(6,9));
//		tabbedp.addTab("�ҵ����", new JTable());
		tabbedp.addTab("֤����Ϣ", new CardInfoPanel());
		c.add(tabbedp);
		
		this.setSize(850, 600);
		Dimension screen = getToolkit().getScreenSize();
		this.setLocation((screen.width-this.getSize().width)/2,
				(screen.height-this.getSize().height)/2);
		this.setVisible(true);
		
		//�رմ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ReaderLibraryFrame(); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
