/**
 * 
 */
package com.core.test.copy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Teacher  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 上午11:13:39  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 上午11:13:39  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Teacher extends Person implements Cloneable {

	/**
	 * 
	 */
	public Teacher() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 * @param address
	 */
	public Teacher(String name, int age, String address) {
		super(name, age, address);
	}
	
	public Teacher(Person person, int marjorYear){
		super(person.getName(), person.getAge(), person.getAddress());
		this.marjorYear = marjorYear;
	}

	private int marjorYear;

	public int getMarjorYear() {
		return marjorYear;
	}

	public void setMarjorYear(int marjorYear) {
		this.marjorYear = marjorYear;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Teacher clone() throws CloneNotSupportedException {
		return (Teacher)super.clone();
	}
	
}
