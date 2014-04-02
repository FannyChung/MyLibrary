/**
 * 
 */
package lClient.view.reader;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author zhongfang
 *
 */
public class CardInfoPanel extends JPanel implements ActionListener{

	//attributes
	private JLabel idLb1,nameLb1,certificateLb1,effectiveLb1,expireLb1,moneyLb1,statusLb1;
	private Vector info;
	private JButton lossBt;
	private JPanel lossP,upP;
	
	public CardInfoPanel() {
		this.setLayout(new BorderLayout());
		
		lossP = new JPanel();
		lossBt = new JButton("挂失卡");
		lossP.add(lossBt);
		this.add(lossP,BorderLayout.SOUTH);
		
		idLb1 = new JLabel("读者证件号:");
		nameLb1 = new JLabel("读者姓名:");
		certificateLb1 = new JLabel("办证日期:");
		effectiveLb1 = new JLabel("生效日期:");
		expireLb1 = new JLabel("失效日期:");
		moneyLb1 = new JLabel("卡内余额:");
		statusLb1 = new JLabel("状态:");
		upP = new JPanel(new GridLayout(4,2));
		
		upP.add(idLb1);
		upP.add(nameLb1);
		upP.add(certificateLb1);
		upP.add(effectiveLb1);
		upP.add(expireLb1);
		upP.add(moneyLb1);
		upP.add(statusLb1);
		
		this.add(upP);
		
		lossBt.addActionListener(this);
	}
	
	public Vector readerInfo(){
		Vector info = new Vector();
		
		return info;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == lossBt)
			reportLoss();
	}

	private void reportLoss() {
		// TODO Auto-generated method stub
	}
}
