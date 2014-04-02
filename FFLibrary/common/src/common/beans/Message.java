/**
 * 
 */
package common.beans;

import java.io.Serializable;

import common.MessageType;
import common.Variable.MessageStatusCode;


/**
 * @author zhongfang
 *
 */
public class Message implements Serializable{

	private Long uid; // 标识客户端身份
	private String name; // TODO: 考虑删除
	private Integer type;//决定是注册还是登陆
	private MessageStatusCode statusCode;//成功还是失败
	private Object data;
	private Object sender;//发送者
	
	public Message() {
		uid = 111111111111111111L;
		name = null;
		type = MessageType.EMPTY;
		statusCode = MessageStatusCode.EMPTY;
		data = null;
		sender = null;
	}
		
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public MessageStatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(MessageStatusCode statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getSender() {
		return sender;
	}
	public void setSender(Object sender) {
		this.sender = sender;
	}
	
	/**
	 * 创建用于增加书籍的Message
	 * @return
	 */
	public static Message addBookMessage(Book book) {
		Message msg = new Message();
		msg.setType(MessageType.BOOK_ADD);
		msg.setData(book);
		return msg;
	}
	
	/**
	 * 创建用于修改书籍的Message
	 * @param user
	 * @return
	 */
	public static Message modifyBookMessage(Book book) {
		Message msg = new Message();
		msg.setType(MessageType.BOOK_MODIFY);
		msg.setData(book);
		return msg;
	}

	/**
	 * 创建用于删除书籍的Message
	 * @param book
	 * @return
	 */
	public static Message deleteBookMessage(Book book) {
		Message msg = new Message();
		msg.setType(MessageType.BOOK_DELETE);
		msg.setData(book);
		return msg;
	}
	/**
	 * 创建用于寻找书籍的Message
	 * @param book
	 * @return
	 */
	public static Message findBookMessage(Book book) {
		Message msg = new Message();
		msg.setType(MessageType.BOOK_FIND);
		msg.setData(book);
		return msg;
	}
	/**
	 * 创建用于增加Reader的Message
	 * @param reader
	 * @return
	 */
	public static Message addReaderMessage(Reader reader) {
		Message msg = new Message();
		msg.setType(MessageType.READER_ADD);
		msg.setData(reader);
		return msg;
	}
	/**
	 * 创建用于修改Reader的message
	 * @param reader
	 * @return
	 */
	public static Message modifyReaderMessage(Reader reader) {
		Message msg = new Message();
		msg.setType(MessageType.READER_MODIFY);
		msg.setData(reader);
		return msg;
	}
	/**
	 * 创建用于删除Reader的Message
	 * @param reader
	 * @return
	 */
	public static Message deleteReaderMessage(Reader reader) {
		Message msg = new Message();
		msg.setType(MessageType.READER_DELETE);
		msg.setData(reader);
		return msg;
	}
	/**
	 * 创建用于寻找书籍的Message
	 * @param reader
	 * @return
	 */
	public static Message findReaderMessage(Reader reader) {
		Message msg = new Message();
		msg.setType(MessageType.READER_FIND);
		msg.setData(reader);
		return msg;
	}
	/**
	 * 创建用于增加Rule的Message
	 * @param rule
	 * @return
	 */
	public static Message addRuleMessage(Rule rule) {
		Message msg = new Message();
		msg.setType(MessageType.RULE_ADD);
		msg.setData(rule);
		return msg;
	}
	/**
	 * 创建用于修改Rule的Message
	 * @param rule
	 * @return
	 */
	public static Message modifyRuleMessage(Rule rule) {
		Message msg = new Message();
		msg.setType(MessageType.RULE_MODIFY);
		msg.setData(rule);
		return msg;
	}
	/**
	 * 创建用于删除Rule的Message
	 * @param rule
	 * @return
	 */
	public static Message deleteRuleMessage(Rule rule) {
		Message msg = new Message();
		msg.setType(MessageType.RULE_DELETE);
		msg.setData(rule);
		return msg;
	}
	/**
	 * 创建用于寻找Rule的Message
	 * @param rule
	 * @return
	 */
	public static Message findRuleMessage(Rule rule) {
		Message msg = new Message();
		msg.setType(MessageType.RULE_FIND);
		msg.setData(rule);
		return msg;
	}
}


