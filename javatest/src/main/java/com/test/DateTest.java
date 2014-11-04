/**
 * 
 */
package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**  
 * @ProjectName：javatest  
 * @TypeName：DateTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-5-16 下午3:23:17  
 * @creater：zhao_zengjun  
 * @updateDate：2014-5-16 下午3:23:17  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class DateTest {

	/**
	 * @throws ParseException 
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) throws ParseException {

		//dateFormat();
		
		long2Date();
		
	}
	
	
	public static void dateFormat() throws ParseException{
		String string = "2010-10-10 10:10:10:123";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string);
		System.out.println(date);
	}
	
	
	public static void long2Date(){
		long s = 0xFFFFFFFFL * 1000;
		System.out.println(s);
		String string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(s));
		System.out.println(string);
	}

}
