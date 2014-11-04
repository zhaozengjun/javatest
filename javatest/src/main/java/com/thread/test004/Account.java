/**
 * 
 */
package com.thread.test004;

/**  
 * @ProjectName：javatest  
 * @TypeName：Account  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-20 下午2:31:40  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-20 下午2:31:40  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Account {
	String name;
	float amount;


	public Account(String name, float amount) {
		this.name = name;
		this.amount = amount;
	}

	public  void deposit(float amt) {
		float tmp = amount;
		tmp += amt;
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1);//模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		amount = tmp;
	}

	public  void withdraw(float amt) {
		float tmp = amount;
		tmp -= amt;
		System.out.println(Thread.currentThread().getName());

		try {
			Thread.sleep(1);//模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        

		amount = tmp;
	}

	public float getBalance() {
		return amount;
	}
}
