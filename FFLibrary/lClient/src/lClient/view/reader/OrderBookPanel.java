/**
 * 
 */
package lClient.view.reader;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import lClient.biz.ShowTable;

/**
 * @author C5115
 *
 */
public class OrderBookPanel extends JPanel {

	private JButton cancelbt;
	private JPanel lowpanel;
	/**
	 * 
	 */
	public OrderBookPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		lowpanel = new JPanel();
		cancelbt = new JButton("È¡ÏûÔ¤Ô¼");
		lowpanel.add(cancelbt);
		this.add(lowpanel,BorderLayout.SOUTH);
		
		
//		this.add(new ShowTable());
	}

}
