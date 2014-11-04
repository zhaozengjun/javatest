/**
 * 
 */
package com.string;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {

	/**
	 * QQ:15221860
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getA());

		System.out.println(getStudent().name);

		System.out.println(getB());

	}

	static String getA() {

		String a = "1";
		try {
			return a;
		} catch (Exception e) {
			a = "2";
			return a;
		} finally {
			System.out.println("hi");
			a = "3";
		}

	}

	static Student getStudent() {

		Student a = new Student();
		a.name = "1";
		try {
			return a;
		} catch (Exception e) {
			a.name = "2";
			return a;
		} finally {
			System.out.println("hi");
			a.name = "3";

		}

	}

	static class Student {
		String name = "";

	}



	//这方法又如何
	static Integer getB() {

		Integer a = new Integer(1);
		try {
			return a;
		} catch (Exception e) {
			a =  new Integer(2);
			return a;
		} finally {
			System.out.println("hi");
			a =  new Integer(3);

		}

	}
}
