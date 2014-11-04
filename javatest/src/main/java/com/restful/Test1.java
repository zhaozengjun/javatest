/**
 * 
 */
package com.restful;

import java.io.IOException;

import us.monoid.web.Resty;
import us.monoid.web.Resty.Option;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-10 下午3:27:04  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-10 下午3:27:04  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test1 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		resty();
	}
	
	
	public static void resty(){
		try {
			Resty r = new Resty(Option.timeout(2000));
			String hello = r.text("http://localhost:8080/web/r", Resty.form("request=11111111111111111")).toString();
			System.out.println(hello);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
