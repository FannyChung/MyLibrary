/**
 * 
 */
package common.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


/**
 * @author zhongfang
 *
 */
public class Order implements Serializable{

	private  int orderId = 1999;
	private Reader reader;
	private Book book;
	private String place;//ȡ��ĵص�
	private int keepDays;
	private Date orderDate;
	
	public Order(Book book,Reader reader){
		this.setOrderId(orderId);
		this.setBook(book);
		this.setReader(reader);
		
		Calendar ca= Calendar.getInstance();
		this.setOrderDate(ca.getTime());
		orderId++;
	}

	
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}


	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the reader
	 */
	public Reader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the keepDays
	 */
	public int getKeepDays() {
		return keepDays;
	}

	/**
	 * @param keepDays the keepDays to set
	 */
	public void setKeepDays(int keepDays) {
		this.keepDays = keepDays;
	}
	
}
