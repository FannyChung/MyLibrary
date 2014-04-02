package common;

public class MessageType {

	public static final Integer EMPTY = null; // 无标识
	public static final Integer BOOK_ADD = 1; 
	public static final Integer BOOK_MODIFY = 2; 
	public static final Integer BOOK_DELETE = 3;
	public static final Integer BOOK_FIND = 4;
	
	public static final Integer READER_ADD = 5;
	public static final Integer READER_MODIFY = 6;
	public static final Integer READER_DELETE = 7;
	public static final Integer READER_FIND = 8;
	
	public static final Integer RULE_ADD = 9;
	public static final Integer RULE_MODIFY = 10;
	public static final Integer RULE_DELETE = 11;
	public static final Integer RULE_FIND =12;
	
	
	/**
	 * 拒绝实例化
	 */
	private MessageType() {
	}
}
