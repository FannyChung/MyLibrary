/**
 * 
 */
package lClient.biz.srv;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author zhongfang
 *
 */
public class Punishment {

	private int punishId=0;
	private Borrow borrow;
	private boolean status;
	private double amount;
	/**
	 * 
	 */
	public Punishment(Borrow borrow) {
		// TODO Auto-generated constructor stub	
		this.setPunishId(punishId);
		punishId++;
		this.setBorrow(borrow);
		this.setStatus(false);
		this.setAmount(borrow.getBook().getPrice());
		
		borrow.getReader().getPayedList().addElement(this);
	}
	/**
	 * @return the punishId
	 */
	public int getPunishId() {
		return punishId;
	}
	/**
	 * @param punishId the punishId to set
	 */
	public void setPunishId(int punishId) {
		this.punishId = punishId;
	}
	/**
	 * @return the borrow
	 */
	public Borrow getBorrow() {
		return borrow;
	}
	/**
	 * @param borrow the borrow to set
	 */
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
