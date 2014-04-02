package common;

import common.beans.Book;
import common.beans.Message;
import common.beans.Reader;
import common.beans.Rule;


/**
 * 
 * @author zhongfang
 *
 */
public final class ObjectTransformer {
	/**
	 * ˽�л����캯������ֹʵ������Ϊ
	 */
	private ObjectTransformer() {
	}
	
	public static Book getBook(Object obj) {
		if (obj != null) {
			return (Book) obj;
		} else {
			return null;
		}
	}
	public static Reader getReader(Object obj) {
		if (obj != null) {
			return (Reader) obj;
		} else {
			return null;
		}
	}
	public static Rule getRule(Object obj) {
		if (obj != null) {
			return (Rule) obj;
		} else {
			return null;
		}
	}
	
	/**
	 * ��Objectת��ΪMessage
	 * �ɹ��򷵻�Message��ʧ�ܷ���null
	 * @param Object
	 * @param Message
	 */
	public static Message getMessage(Object obj) {
		if (obj != null) {
			return (Message) obj;
		} else {
			return null;
		}
	}
}
