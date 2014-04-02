/**
 * 
 */
package lClient.view.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Variable;

/**
 * @author zhongfang
 *
 */
public class RuleInfoFrame extends JFrame implements ActionListener,Variable{

	private JLabel idL,nameL,maxBorrowDaysL,maxRenewDaysL,maxRenewTimesL,keepOrderDaysL;
	private JTextField idF,nameF,maxBorrowDaysF,maxRenewDaysF,maxRenewTimesF,keepOrderDaysF;
	private Container c;
	private JButton okay,cancel;
	private JPanel upPanel,lowPanel;
	private ManagePanel parentP;
	private int manageType;
	/**
	 * 
	 */
	public RuleInfoFrame(ManagePanel parentP,int i) {
		// TODO Auto-generated constructor stub
		this.parentP=parentP;
		this.manageType=i;
		
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		
		upPanel=new JPanel(new GridLayout(6,2));
		idL=new JLabel("规则编号");
		nameL=new JLabel("规则名称");
		maxBorrowDaysL=new JLabel("最大借阅天数");
		maxRenewDaysL=new JLabel("最大续借天数");
		maxRenewTimesL=new JLabel("最大续借次数");
		keepOrderDaysL=new JLabel("保存预约天数");
		idF=new JTextField();
		nameF=new JTextField();
		maxBorrowDaysF=new JTextField();
		maxRenewDaysF=new JTextField();
		maxRenewTimesF=new JTextField();
		keepOrderDaysF=new JTextField();
		
		upPanel.add(idL);
		upPanel.add(idF);
		upPanel.add(nameL);
		upPanel.add(nameF);
		upPanel.add(maxBorrowDaysL);
		upPanel.add(maxBorrowDaysF);
		upPanel.add(maxRenewDaysL);
		upPanel.add(maxRenewDaysF);
		upPanel.add(maxRenewTimesL);
		upPanel.add(maxRenewTimesF);
		upPanel.add(keepOrderDaysL);
		upPanel.add(keepOrderDaysF);
		
		lowPanel=new JPanel(new FlowLayout());
		okay=new JButton("ȷ��");
		cancel=new JButton("ȡ��");
		lowPanel.add(okay);
		lowPanel.add(cancel);
		
		c.add(lowPanel,BorderLayout.SOUTH);
		c.add(upPanel);
		
		okay.addActionListener(this);
		cancel.addActionListener(this);
		
		this.setSize(550, 350);
		Dimension screen = getToolkit().getScreenSize();
		this.setLocation((screen.width-this.getSize().width)/2,
				(screen.height-this.getSize().height)/2);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==okay){
			if(manageType==ADD){
				//TODO 获取信息，添加，
			}else{
				//TODO 
			}
		}else if(arg0.getSource()==cancel){
			shutDown();
		}
	}
	private void shutDown() {
		// TODO Auto-generated method stub
		this.dispose();
		this.parentP.getParentF().setVisible(true);
	}
	private void ComponentByManageType(){
		if(manageType==MODIFY){
			//利用rule信息来设置面板
			idF.setEditable(false);
			
		}
	}

}
