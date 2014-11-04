/**
 * 
 */
package com.core.test.copy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 上午11:20:59  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 上午11:20:59  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	/**
	 * @throws CloneNotSupportedException 
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		Teacher teacher = new Teacher("t1", 20, "address1");
		Teacher teacher2 = new Teacher("t2", 30, "address2");
		Class class1 = new Class("class1", "add1", teacher);
		System.out.println(class1.getName());
		System.out.println(class1.getMaster().getName());
		Class class2 = class1.clone();
		class2.setName("class2");
		class2.getMaster().setName("class2-teacher");
		System.out.println(class2.getName());
		System.out.println(class2.getMaster().getName());
		class2.setMaster(teacher2);
		System.out.println(class1.getName());
		System.out.println(class1.getMaster().getName());
		System.out.println(class2.getName());
		System.out.println(class2.getMaster().getName());
	}

}
