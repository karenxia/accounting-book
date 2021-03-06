package net.karen.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;

public class csvWR implements InformationWR{
	private static final String COMMA_DELIMITER = ",";
	private static final String DOUBLE_QUOTER = "\"";
	private static final String NEW_LINE_SEPARATOR = "\n";

	@Override
	public void informationReader(Object filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader((String)filePath))) {
			String eachLine;
			while((eachLine = br.readLine()) != null) {
				// Need to consider more, such as has seperator in the content
				String []contents = eachLine.split(COMMA_DELIMITER);
			}
		} catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	@Override
	public void informationWriter(Object filePath, Object obj) {
		// If file not exist, need add header
		String content = obj.toString();
		System.out.println("Will add: " + content.toString());
		try(FileWriter fw = new FileWriter((String)filePath, true)) {
			fw.append(content);
		} catch (IOException e) {
            e.printStackTrace();
        } 
	}
}