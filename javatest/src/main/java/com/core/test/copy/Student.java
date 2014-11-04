/**
 * 
 */
package com.core.test.copy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Student  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 上午11:12:03  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 上午11:12:03  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Student extends Person {

	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 * @param address
	 */
	public Student(String name, int age, String address) {
		super(name, age, address);
	}

	public Student(Person person, Class class1){
		super(person.getName(), person.getAge(), person.getAddress());
		this.class1 = class1;
	}
	
	private Class class1;

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

}
