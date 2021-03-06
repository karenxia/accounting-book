package net.accounting;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import net.accounting.accountingItem;
import net.karen.utils.csvWR;
import net.karen.utils.InformationWR;
import net.karen.common.constant;

public class accountingBook{
	private LocalDate currentDate;
	private String userName;
	public InformationWR informationHandler;
	// Option: 
	// 0: Both DB and file
	// 1: DB
	// 2: file: default
	public accountingBook(String userName, int option) {
		if(userName.length() != 0) {
			this.userName = userName;
		}
		if(option == 2) {
			csvHandler = new csvWR();
		}
	}

	public void addItem(String item, float account, String localDate) {
		if(item.length() != 0 &&  localDate.length() > 9) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			this.currentDate = LocalDate.parse(localDate, formatter);
		}
	}

	public static void help() {
        String repeated = new String(new char[80]).replace("\0", "*");
		System.out.println(repeated);
		System.out.println("Please input your user name, date, item and account");
		System.out.println(repeated);
	}

	@Override public String toString() {
		return constant.DOUBLE_QUOTER + "item" + constant.DOUBLE_QUOTER + constant.COMMA_DELIMITER + constant.DOUBLE_QUOTER + "date" + constant.DOUBLE_QUOTER + constant.COMMA_DELIMITER + constant.DOUBLE_QUOTER + "account" + constant.DOUBLE_QUOTER + constant.NEW_LINE_SEPARATOR;
	}
	
	public static void main(String[] args) {
		if(args.length != 4) {
			accountingBook.help();
		}
		else {
			// Get parameters
			String name = args[0];
			String date = args[1];
			String item = args[2];
			String account = args[3];
			accountingBook atBook = new accountingBook(name);
			for(String s:args) {
				System.out.println(s);
			}
			// Write content to csv file
			String filePath = name + ".csv";
			File f = new File(filePath);
			if(!f.exists()) {
				System.out.println("File not exists, write header to " + filePath);
				// Write header to csv file
				atBook.csvHandler.informationWriter(filePath, atBook);
			}
			//Write item to csv file
			accountingItem atItem = new accountingItem(item, date, account);
			atBook.csvHandler.informationWriter(filePath, atItem);
		}
	}        
}
