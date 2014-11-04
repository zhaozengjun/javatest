/**
 * 
 */
package com.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * @ProjectName：javatest  
 * @TypeName：HashcodeTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-13 下午3:24:25  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-13 下午3:24:25  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

class User{
	private String name;
	private int age;
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
//	@Override
//	public int hashCode() {
//		return 0;
//	}
}

public class HashcodeTest {
	
	public static void main(String[] args) {
		User user = new User("zzj", 20);
		User user2 = new User("milan", 22);
		Set<User> users = new HashSet<User>();
		long c = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			users.add(new User("" + i, i));
		}
		System.out.println(users.size());
		System.out.println((System.currentTimeMillis() - c)/1000D);
	}
	

}
