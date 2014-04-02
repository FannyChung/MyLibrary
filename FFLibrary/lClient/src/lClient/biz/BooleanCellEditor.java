/**
 * 布尔值单元格编辑器
 */
package lClient.biz;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * @author C5115
 *
 */

public class BooleanCellEditor extends AbstractCellEditor implements TableCellEditor{

	private JCheckBox check;
	
	/**
	 * 
	 */
	public BooleanCellEditor() {
		// TODO Auto-generated constructor stub
		super();
		check = new JCheckBox();
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return Boolean.valueOf(check.isSelected());
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int col) {
		// TODO Auto-generated method stub
		boolean b =(Boolean) value;
//		check.setSelected(b.booleanValue());
		check.setSelected(b);
		return check;
	}

}
