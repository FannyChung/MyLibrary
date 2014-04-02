package common;

/**
 * @author zhongfang
 *
 */
public interface Variable {
	public static final String[] BOOK_VARIABLES_LIST = {"涔︾紪鍙�,"涔﹀悕","璐ｄ换鑰�
		,"绫诲瀷","绱功鍙�,"鍑虹増绀�,"鍑虹増鏃堕棿","鍏ラ鏃堕棿","鍗曚环","鐘舵�","闄勬敞"};
	//"棣嗚棌鍦�
	public static final String[] READER_VARIABLES_LIST = {"","","","","","","","","",""};
	
	public static final String[] RULE_VARIABLES_LIST={"","","","",""};
	public static final String[] BOOK_TYPE_LIST = {"椹厠鎬濅富涔�,"鍝插銆佸畻鏁�,"绀句細绉戝鎬昏",
		"鏀挎不銆佹硶寰�,"鍐涗簨","缁忔祹","鏂囧寲銆佺瀛︺�鏁欒偛銆佷綋鑲�,"璇█銆佹枃瀛�,"鏂囧","鑹烘湳","鍘嗗彶銆佸湴鐞�,"鑷劧绉戝鎬昏","鏁扮悊绉戝涓庡寲瀛�,
		"澶╂枃瀛︺�鍦扮悆绉戝","鐢熺墿绉戝","鍖昏嵂銆佸崼鐢�,"鍐滀笟绉戝","宸ヤ笟鎶�湳","浜ら�杩愯緭","鑸┖銆佽埅澶�,"鐜绉戝,瀹夊叏绉戝","缁煎悎鎬у浘涔�};
	
	public static final String[] BOOK_STATUS= {"鍏ラ涓�,"鍙�","宸插�鍑�,"宸查绾�,"宸叉寕澶�,"淇濈暀鏈�};
	public static final String[] READER_STATUS={"娉ㄥ唽涓�,"鏈縺娲�,"姝ｅ父","宸叉寕澶�};
	public enum readerStatus{鏈縺娲�姝ｅ父,宸叉寕澶眪;
	public enum readerType{鏈鐢�鐮旂┒鐢�鏁欏笀};
	public enum StorePlace{涓浘闃呰瀹�,涓浘闃呰瀹�,涓浘闃呰瀹�,涓浘闃呰瀹�,澶栨枃鍥句功闃呰瀹�淇濈暀鏈槄瑙堝;

	public static String[] getAll() {
		// TODO Auto-generated method stub
		String[] s={"涓浘闃呰瀹�","涓浘闃呰瀹�","涓浘闃呰瀹�","涓浘闃呰瀹�","澶栨枃鍥句功闃呰瀹�,"淇濈暀鏈槄瑙堝"};
		return s;
	}};
	
	final int BOOK_MANAGE=1;
	final int READER_MANAGE=2;
	final int RULE_MANAGE=3;
	
	final int ADD=1;
	final int MODIFY=2;
	final int DELETE=3;
	
	public enum MessageStatusCode{EMPTY,SUCCESS,FAILED};
	
}
