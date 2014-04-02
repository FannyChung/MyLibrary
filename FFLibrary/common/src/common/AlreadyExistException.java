/**
 * 
 */
package common;

import javax.swing.JOptionPane;

/**
 * @author zhongfang
 *
 */
public class AlreadyExistException extends Exception{

	/**
	 * 
	 */
	public AlreadyExistException(String s) {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(null, s);
	}

}
