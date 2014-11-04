/**
 * 
 */
package com.core.test.copy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Person  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 上午11:10:30  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 上午11:10:30  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Person {

	private String name;
	private int age;
	private String address;
	
	/**
	 * 
	 */
	public Person() {
		super();
	}
	/**
	 * @param name
	 * @param age
	 * @param address
	 */
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
