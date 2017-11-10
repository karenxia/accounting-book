package net.accounting;

import net.karen.common.constant;

public class accountingItem{
	String item;
	String date;
	String account;
	
	public accountingItem(String item, String date, String account) {
		this.item = item;
		this.date = date;
		this.account = account;
	}
	
	@Override public String toString() {
		// cvs format
		// "2017-11-09","shopping","-250"
		String ret;
		ret = constant.DOUBLE_QUOTER + item + constant.DOUBLE_QUOTER + constant.COMMA_DELIMITER + constant.DOUBLE_QUOTER + date + constant.DOUBLE_QUOTER + constant.COMMA_DELIMITER + constant.DOUBLE_QUOTER + account + constant.DOUBLE_QUOTER + constant.NEW_LINE_SEPARATOR;
		return ret;
	}
	

}
