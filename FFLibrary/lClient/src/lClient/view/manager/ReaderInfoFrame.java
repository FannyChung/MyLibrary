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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lClient.srv.ClientSrvReaderHelper;
import common.Variable;
import common.beans.Reader;
import common.beans.Rule;
import common.dao.RuleDao;

/**
 * @author zhongfang
 *
 */
public class ReaderInfoFrame extends JFrame implements Variable,ActionListener{

	private JLabel idL,certifiTimeL,effectiveL,expireL,statusL,ruleL,moneyL;
	private JTextField idF,certifiTimeF,effectiveF,expireF,moneyF;
	private JComboBox ruleF,statusF;
	private Container c;
	private int manageType;
	private JButton okay,cancel;
	private JPanel upPanel,lowPanel;
	private ManagePanel parent;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD"); 
	private ClientSrvReaderHelper clientSrv=new ClientSrvReaderHelper();
	/**
	 * 
	 * @param parent
	 * @param manageType
	 */
	public ReaderInfoFrame(ManagePanel parent,int manageType){
		this.parent=parent;
		this.manageType=manageType;
		
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		upPanel=new JPanel(new GridLayout(7,1));
		lowPanel=new JPanel(new FlowLayout());
		
		idL= new JLabel("����֤���");
		certifiTimeL=new JLabel("ע������");
		effectiveL=new JLabel("��Ч����");
		expireL=new JLabel("ʧЧ����");
		moneyL=new JLabel("���");
		statusL=new JLabel("״̬");
		ruleL=new JLabel("ʹ�ù���");
		idF=new JTextField();
		certifiTimeF=new JTextField();
		effectiveF=new JTextField();
		expireF=new JTextField();
		statusF=new JComboBox(READER_STATUS);
		moneyF=new JTextField();
		
		Vector v=new Vector();
		v=RuleDao.getAll();
		Vector s=new Vector();
		String str=null;
		Rule rule;
		for(int i1=0;i1<v.size();i1++){
			rule=(Rule) v.get(i1);
			str=rule.getRuleName();
			s.addElement(str);
		}
		ruleF=new JComboBox(s);
		okay=new JButton("ȷ��");
		cancel=new JButton("ȡ��");

		determineComponents();
		upPanel.add(idL);
		upPanel.add(idF);
		upPanel.add(certifiTimeL);
		upPanel.add(certifiTimeF);
		upPanel.add(effectiveL);
		upPanel.add(effectiveF);
		upPanel.add(expireL);
		upPanel.add(expireF);
		upPanel.add(moneyL);
		upPanel.add(moneyF);
		upPanel.add(statusL);
		upPanel.add(statusF);
		upPanel.add(ruleL);
	    upPanel.add(ruleF);
		lowPanel.add(okay);
		lowPanel.add(cancel);
		c.add(lowPanel,BorderLayout.SOUTH);
		c.add(upPanel);
		
		this.setSize(400, 350);
		Dimension screen = getToolkit().getScreenSize();
		this.setLocation((screen.width-this.getSize().width)/2,
				(screen.height-this.getSize().height)/2);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		okay.addActionListener(this);
		cancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okay){
			if(manageType==ADD){
				Reader reader=gerReader();
				if(idF.getText().equals(""))
					JOptionPane.showMessageDialog(this, "编号不能为空！");
				else{
					reader=clientSrv.addReader(reader);
					
					if(reader==null)
						JOptionPane.showMessageDialog(this, "添加失败，该读者证已存在");
					else{
						JOptionPane.showMessageDialog(this, "添加成功");
						shutDown();
					}
				}
			}
			else{
				String s=expireF.getText();
				try {
					Date d=sdf.parse(s);
					
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(this, "请输入正确的数据类型");
				}
			}
		}else{
			shutDown();
		}
	}
	/**
	 * 关闭当前窗口
	 */
	private void shutDown(){
		this.dispose();
		this.parent.getParentF().setVisible(true);
	}
	/**
	 * 获取读者信息
	 * @return
	 */
	public Reader gerReader(){
		Reader r=new Reader();
		r.setReaderId(Integer.parseInt(idF.getText()));
		r.setCertificateTime(certifiTimeF.getText());
		r.setEffectiveTime(effectiveF.getText());
		r.setExpireTime(expireF.getText());
		r.setMoney(Double.parseDouble(moneyF.getText()));
		r.setStatus((String) statusF.getSelectedItem());
		String ruleName=(String) ruleF.getSelectedItem();
		Rule rule =RuleDao.getRule(ruleName);
		r.setRule(rule);
		return r;
	}
	/**
	 * 通过管理类型来决定面板上的控件显示
	 */
	public void determineComponents(){
		if(manageType==ADD){
			certifiTimeF.setText("����");
			certifiTimeF.setEditable(false);
			effectiveF.setText("�����");
			effectiveF.setEditable(false);
			expireF.setText("�����");
			expireF.setEditable(false);
			statusF.setSelectedIndex(0);
			statusF.setEnabled(false);
		}else{
			Reader reader=new Reader();
			int readerId=this.parent.getSelectedId();
			idF.setText(Integer.toString(readerId));
			reader = clientSrv.modifyReader(reader);
			if(reader==null){
				JOptionPane.showMessageDialog(this, "û��ѡ�У�");
			}
			
			idF.setEditable(false);
//			certifiTimeF.setText(t);
			certifiTimeF.setEditable(false);
			effectiveF.setEditable(false);
		}
	}
}
