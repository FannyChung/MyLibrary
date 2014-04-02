/**
 * 在试图中显示列表
 */
package lClient.biz;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

/**
 * @author zhongfang
 *
 */
public class ShowTable extends JTable {
	private MyTableModel tm;
	/**
	 * @param arg0
	 * @param arg1
	 */
	public ShowTable(String sql,String[] columnNames) {
		// TODO Auto-generated constructor stub
		tm = new MyTableModel(sql,columnNames);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		JScrollPane scroll = new JScrollPane(this,v,h);
	}
}
