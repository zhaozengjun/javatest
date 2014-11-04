/**
 * 
 */
package com.core.test.reflect;

/**  
 * @ProjectName：javatest  
 * @TypeName：B  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-8 下午4:34:36  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-8 下午4:34:36  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class B extends A implements IA {
	
	public String number;
	
	private String address;
	
	public B(){
		
	}
	
	public B(String address){
		this.address = address;
	}

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	/* (non-Javadoc)
	 * @see com.core.test_reflect.IA#sayHello()
	 */
	@Override
	public void sayHello() {
		System.out.println("this is b");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
