/**
 * 
 */
package com.thread.test010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


/**  
 * @ProjectName：CUTWORDS  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 下午3:41:07  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 下午3:41:07  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
		test01();
		test11();
		

		
		
	}
	
	public static void test1(List<String> list){
		List<String> list2 = new ArrayList<String>(list);
		for (int i = 0; i < list2.size(); i++) {
			list2.set(i, list2.get(i) + "111111");
		}
//		for (String string : list2) {
//			System.out.println(string);
//		}
	}
	
	
	public static void test11(){
		List<String> list = new ArrayList<String>();
		list.add("zzj");
		list.add("milan");
		for (String string : list) {
			System.out.println(string);
		}
		test1(list);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void test(List<Map<String, String>> list){
		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>(list);
		for (int i = 0; i < list2.size(); i++) {
			list2.get(i).put("name", list2.get(i).get("name") + "111111");
		}
//		for (Map<String, String> record2 : list2) {
//			System.out.println(record2.getStr("name"));
//		}
	}
	
	public static void test01(){
		List<Map<String, String>> records = new ArrayList<Map<String, String>>();
		Map<String, String> record = new Hashtable<String, String>();
		record.put("name", "zzj");
		records.add(record);
		record = new Hashtable<String, String>();
		record.put("name", "milan");
		records.add(record);
		for (Map<String, String> record2 : records) {
			System.out.println(record2.get("name"));
		}
		test(records);
		for (Map<String, String> record2 : records) {
			System.out.println(record2.get("name"));
		}
	}

}
