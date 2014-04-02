/**
 * 书籍与读者的关系类，是“借书”“还书”“预约”“挂失”的父类
 */
package lClient.biz.srv;

import java.util.Date;

import common.beans.Book;
import common.beans.Reader;

/**
 * @author C5115
 *
 */
public class BookAndReader {

	private Book book;
	private Reader reader;
	private Date startDate;
	/**
	 * 
	 */
	public BookAndReader(Book book,Reader reader, Date startDate) {
		// TODO Auto-generated constructor stub
		this.setBook(book);
		this.setReader(reader);
		this.setStartDate(startDate);
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

}
