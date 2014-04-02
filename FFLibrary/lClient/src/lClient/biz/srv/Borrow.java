/**
 * 
 */
package lClient.biz.srv;

import java.util.Calendar;
import java.util.Date;

import common.beans.Book;
import common.beans.Reader;

/**
 * @author zhongfang
 *
 */
public class Borrow{

	private static int borrowId = 10000;
	private Reader reader;
	private Book book;
	private Date startDate,lastDate;
	private int renewTimes;

	public Borrow(Reader reader,Book book){
//		int days =reader.getRule().getMaxBorrowDays();
		
		Calendar ca = Calendar.getInstance();
		this.setStartDate(ca.getTime());
		ca.add(Calendar.DATE, 30);
		setLastDate(ca.getTime());
		
		this.setBorrowId(borrowId);
		borrowId++;
		
//		book.setStatus(bookStatus.ря╫ХЁЖ);

		this.setRenewTimes(0);
	}

	
	/**
	 * @return the borrowId
	 */
	public int getBorrowId() {
		return borrowId;
	}

	/**
	 * @param borrowId the borrowId to set
	 */
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the lastDate
	 */
	public Date getLastDate() {
		return lastDate;
	}

	/**
	 * @param lastDate the lastDate to set
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}


	/**
	 * @return the renewTimes
	 */
	public int getRenewTimes() {
		return renewTimes;
	}


	/**
	 * @param renewTimes the renewTimes to set
	 */
	public void setRenewTimes(int renewTimes) {
		this.renewTimes = renewTimes;
	}
}
