/**
 * 
 */
package com.thread.test010;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test03  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 下午3:20:59  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 下午3:20:59  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

class Data implements Runnable{
	List<String> list = new ArrayList<String>();
	List<String> list2 = new ArrayList<String>();
	public Data(){}
	public Data(List<String> list){
		this.list = list;
	}
	
	public void add(List<String> list){
		for (int i = 0; i < list.size(); i++) {
			this.list2.add(list.get(i) + "--" + Thread.currentThread().getName() + "--" + i);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
	}
	
}


class Data1 implements Runnable{
	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	public Data1(List<Map<String, String>> list){
		this.list = list;
	}
	@Override
	public void run() {
		
	}
}


public class Test03 {
	String ss = "aa";
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 1000; i++) {
			Map<String, String> map = new Hashtable<String, String>();
			map.put("name", "name" + i);
			list.add(map);
		}
//		for (Map<String, String> map : list) {
//			System.out.println(map.get("name"));
//		}
//		Test.test(list);
//		for (Map<String, String> map : list) {
//			System.out.println(map.get("name"));
//		}
		ExecutorService service = Executors.newFixedThreadPool(3);
		try {
			service.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		System.out.println("结束");
	}

}
