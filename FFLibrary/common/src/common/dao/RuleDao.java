/**
 * 
 */
package common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.beans.Rule;

/**
 * @author zhongfang
 *
 */
public class RuleDao {

	private static Vector vct=new Vector();
	private static String sql=null;
	private static Statement state=null;
	private static ResultSet rs=null;
	private static String name;
	private static int id,maxBorrowDays,maxRenewDays,maxRenewTimes,keepOrderDays;
	private static Rule rule;
	
	public static void initialize(){
		try {
			state=DAO.initialize().createStatement();
			System.out.println("成功打开数据库");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Vector getAll(){
		sql="select * from tb_rule";
		initialize();
		try {
			rs=state.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt(1);
				name=rs.getString(2);
				maxBorrowDays=rs.getInt(3);
				maxRenewDays=rs.getInt(4);
				maxRenewTimes=rs.getInt(5);
				keepOrderDays=rs.getInt(6);
				rule=new Rule(id, name, maxBorrowDays, maxRenewDays, maxRenewTimes, keepOrderDays);
				vct.addElement(rule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DAO.closeDB();
		return vct;
	}
	
	private static void createTable(){
		initialize();
		sql="create table tb_rule(Id integer primary key,Name char(20), MaxBorrowDays integer, "
				+ "MaxRenewDays integer, MaxRenewTimes integer, KeepOrderDays integer)";
		try {
			state.executeUpdate("drop table tb_rule");
			System.out.println("成功删除表");
			int i=state.executeUpdate(sql);
			System.out.println("成功创建表Rule");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminate();
	}
	
	public static void main(String[] args){
		createTable();
	}
	/**
	 * 
	 * @param ruleId
	 * @return
	 */
	public static Rule getRule(String ruleName){
		sql="select * from tb_rule where Name="+ruleName+"";
		initialize();
		try {
			rs=state.executeQuery(sql);
			if(rs.next()){
				id=rs.getInt(1);
				name=rs.getString(2);
				maxBorrowDays=rs.getInt(3);
				maxRenewDays=rs.getInt(4);
				maxRenewTimes=rs.getInt(5);
				keepOrderDays=rs.getInt(6);
				rule=new Rule(id,name,maxBorrowDays,maxRenewDays,maxRenewTimes,keepOrderDays);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminate();
		return rule;
	}
	private static void terminate() {
		// TODO Auto-generated method stub
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DAO.terminate();
	}
}
