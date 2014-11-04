/**
 * 
 */
package com.core.test.copy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Class  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 上午11:12:22  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 上午11:12:22  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Class implements Cloneable{

	private String name;
	private String address;
	private Teacher master;
	
	
	
	/**
	 * 
	 */
	public Class() {
		super();
	}
	/**
	 * @param name
	 * @param address
	 * @param master
	 */
	public Class(String name, String address, Teacher master) {
		super();
		this.name = name;
		this.address = address;
		this.master = master;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Teacher getMaster() {
		return master;
	}
	public void setMaster(Teacher master) {
		this.master = master;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Class clone() throws CloneNotSupportedException {
		Class clone = (Class)super.clone();
		clone.master = master.clone();
		return clone;
	}

	
	
}
