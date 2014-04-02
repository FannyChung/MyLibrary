/**
 * 
 */
package common.beans;

import java.io.Serializable;

/**
 * @author zhongfang
 *
 */
public class Rule implements Serializable{

	private int ruleId;
	private String ruleName;
	private int maxBorrowDays,MaxRenewDays,MaxRenewTimes,keepOrderDays;
	
	public Rule(int ruleId,String ruleName,int maxBo,int maxR,int MaxRT,int kOD){
		this.setRuleId(ruleId);
		this.setRuleName(ruleName);
		this.setMaxBorrowDays(maxBo);
		this.setMaxRenewDays(maxR);
		this.setMaxRenewTimes(MaxRT);
		this.setKeepOrderDays(kOD);
		
	}
	/**
	 * @return the ruleId
	 */
	public int getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(int ruleId) {
		ruleId = ruleId;
	}
	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}
	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		ruleName = ruleName;
	}
	/**
	 * @return the maxBorrowDays
	 */
	public int getMaxBorrowDays() {
		return maxBorrowDays;
	}
	/**
	 * @param maxBorrowDays the maxBorrowDays to set
	 */
	public void setMaxBorrowDays(int maxBorrowDays) {
		this.maxBorrowDays = maxBorrowDays;
	}
	/**
	 * @return the maxRenewDays
	 */
	public int getMaxRenewDays() {
		return MaxRenewDays;
	}
	/**
	 * @param maxRenewDays the maxRenewDays to set
	 */
	public void setMaxRenewDays(int maxRenewDays) {
		MaxRenewDays = maxRenewDays;
	}
	/**
	 * @return the maxRenewTimes
	 */
	public int getMaxRenewTimes() {
		return MaxRenewTimes;
	}
	/**
	 * @param maxRenewTimes the maxRenewTimes to set
	 */
	public void setMaxRenewTimes(int maxRenewTimes) {
		MaxRenewTimes = maxRenewTimes;
	}
	/**
	 * @return the keepOrderDays
	 */
	public int getKeepOrderDays() {
		return keepOrderDays;
	}
	/**
	 * @param keepOrderDays the keepOrderDays to set
	 */
	public void setKeepOrderDays(int keepOrderDays) {
		this.keepOrderDays = keepOrderDays;
	}
}
