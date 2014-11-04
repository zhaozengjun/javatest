/**
 * 
 */
package com.java_youhua.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @ProjectName：javatest
 * @TypeName：Test
 * @TypeDesc：
 * @author：Administrator
 * 
 */
public class Test {

	/**
	 * @author：Administrator
	 * @Title: main
	 * @param args
	 *            void
	 * @throws
	 */
	public static void main(String[] args) {
		// test1();
		test2();
	}

	public static void test1() {
		// Map<String, String> map = new Hashtable<String, String>();
		// Map<String, String> map = new LinkedHashMap<String, String>();
		Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f,
				true);
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.get("3");
		for (Iterator<Entry<String, String>> iterator = map.entrySet()
				.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	public static void test2() {
		Map<Inner, Inner> map = new TreeMap<Inner, Inner>();
		map.put(new Inner("11", "aa"), new Inner("11", "aa"));
		map.put(new Inner("22", "bb"), new Inner("22", "bb"));
		map.put(new Inner("33", "cc"), new Inner("33", "cc"));
		map.put(new Inner("44", "dd"), new Inner("44", "dd"));

		Iterator<Inner> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Inner inner = (Inner) iterator.next();
			System.out.println(inner.getNo() + ", " + inner.getName());
		}
	}

}
