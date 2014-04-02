/**
 * 
 */
package common.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.Variable;
import common.Variable.readerStatus;

/**
 * @author zhongfang
 *
 */
public class Reader implements Variable{

	private int readerId;
	private String readerName;
	private String certificateTime,effectiveTime,expireTime;
	private double money;
	private Vector borrowingList= new Vector(),borrowedList= new Vector(),orderList= new Vector(),payedList= new Vector(),loveList= new Vector();
	private Rule rule;
	private String status;
	private readerType type;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	public Reader(int readerId,String readerName,String status,double money,Rule rule){
		this.setReaderId(readerId);
		this.setReaderName(readerName);
		
		Calendar ca =Calendar.getInstance();
		Date d = ca.getTime();
		certificateTime=sdf.format(d);
		ca.add(Calendar.DATE, 2);
		effectiveTime=sdf.format(ca.getTime());
		ca.add(Calendar.YEAR, 4);
		expireTime=sdf.format(ca.getTime());
		
		this.setRule(rule);
		this.setMoney(money);
		this.setType(type);
		this.setStatus(status);
	}
	
	public Reader(){
		this.setReaderId(0);
		this.setReaderName(null);
		this.setCertificateTime(null);
		this.setEffectiveTime(null);
		this.setExpireTime(null);
		this.setRule(null);
		this.setStatus(null);
		this.setMoney(0);
	}
	
	/**
	 * @return the certificateTime
	 */
	public String getCertificateTime() {
		return certificateTime;
	}
	/**
	 * @param certificateTime the certificateTime to set
	 */
	public void setCertificateTime(String certificateTime) {
		this.certificateTime = certificateTime;
	}
	/**
	 * @return the effectiveTime
	 */
	public String getEffectiveTime() {
		return effectiveTime;
	}
	/**
	 * @param effectiveTime the effectiveTime to set
	 */
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	/**
	 * @return the expireTime
	 */
	public String getExpireTime() {
		return expireTime;
	}
	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * @return the type
	 */
	public readerType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(readerType type) {
		this.type = type;
	}

	/**
	 * @param book
	 */
	public void collectBook(Book book){
		this.loveList.addElement(book);
	}
//	/**
//	 * ���飬ͬʱ����������ڽ��ĵ��б���
//	 * @param book
//	 */
//	public void BorrowBook(Book book){
//		if(this.getStatus()==readerStatus.����){
//		this.getPunished();            //ÿ�ν���ǰ��Ҫ����ԭ���ķ���
//		if(book.getStatus()==bookStatus.�ɽ�){
//			Calendar ca = Calendar.getInstance();
//			Date t = ca.getTime();
//			
//			Borrow borrow  = new Borrow(this,book);
//			borrowingList.addElement(borrow);
//			System.out.println("����ɹ���");
//		}else{
//			System.out.println("���ɽ��");
//		}
//		}else{
//			System.out.println("����֤����ʹ��");
//		}
//	}
//	/**
//	 * ���飬ͬʱ����������ڽ��ĵ��б���
//	 * @param book
//	 */
//	public void BorrowBook(Book book){
//		if(this.getStatus()==readerStatus.����){
//		this.getPunished();            //ÿ�ν���ǰ��Ҫ����ԭ���ķ���
//		if(book.getStatus()==bookStatus.�ɽ�){
//			Calendar ca = Calendar.getInstance();
//			Date t = ca.getTime();
//			
//			Borrow borrow  = new Borrow(this,book);
//			borrowingList.addElement(borrow);
//			System.out.println("����ɹ���");
//		}else{
//			System.out.println("���ɽ��");
//		}
//		}else{
//			System.out.println("����֤����ʹ��");
//		}
//	}
//
//	/**
//	 * @param borrow
//	 */
//	public void returnBook(Borrow borrow){
//		if(this.getStatus()==readerStatus.����){
//		ReturnBook returnb = new ReturnBook(borrow);
//		this.borrowingList.removeElement(borrow);
//		this.borrowedList.addElement(borrow);
//		}else{
//			System.out.println("����֤����ʹ��");
//
//		}
//	}
//	/**
//	 * @param book
//	 */
//	public void orderBook(Book book){
//		if(book.getStatus()==bookStatus.�ѽ��){
//			Order order = new Order(book,this);
//			this.orderList.addElement(book);
//		}else{
////			JOptionPane.showMessageDialog(null,"����ԤԼ");
//			System.out.println("����ԤԼ");
//		}
//	}
//	/**
//	 * ����
//	 * @param borrow
//	 */
//	public void renewBook(Borrow borrow){
//		if(borrow.getRenewTimes()<this.getRule().getMaxRenewTimes()){
//			Date d = borrow.getLastDate();
//			Calendar ca = Calendar.getInstance();
//			ca.setTime(d);
//			int day = this.getRule().getMaxRenewDays();
//			ca.add(Calendar.DAY_OF_YEAR, day);
//			borrow.setLastDate(ca.getTime());
//		}else{
//			System.out.println("�����������������������裡");
//		}
//		
//	}
//	
//	public void getPunished(){
//		Vector pList= this.getPayedList();
//		for(int i = 0;i<pList.size();i++){//Ϊ���гͷ�����
//			Punishment pu =(Punishment)pList.get(i);
//			if(pu.isStatus());
//			else{                                  //�����û��Ϊ�ͷ�����
//				double money = this.getMoney()-pu.getAmount();
//				pu.setStatus(true);
//			}
//		}
//	}
	/**
	 * @return the readerId
	 */
	public int getReaderId() {
		return readerId;
	}
	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	/**
	 * @return the readerName
	 */
	public String getReaderName() {
		return readerName;
	}
	/**
	 * @param readerName the readerName to set
	 */
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param readerStatus the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the borrowingList
	 */
	public Vector getBorrowingList() {
		return borrowingList;
	}
	/**
	 * @return the borrowedList
	 */
	public Vector getBorrowedList() {
		return borrowedList;
	}
	/**
	 * @return the orderList
	 */
	public Vector getOrderList() {
		return orderList;
	}
	/**
	 * @return the payedList
	 */
	public Vector getPayedList() {
		return payedList;
	}
	/**
	 * @return the loveList
	 */
	public Vector getLoveList() {
		return loveList;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
