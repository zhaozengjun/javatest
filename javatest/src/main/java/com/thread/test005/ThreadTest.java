/**
 * 
 */
package com.thread.test005;

/**  
 * @ProjectName：javatest  
 * @TypeName：ThreadTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-20 下午3:49:44  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-20 下午3:49:44  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

public class ThreadTest
{
	public static void main(String[] args)
	{
		Example example = new Example();
		Example example1 = new Example();

		Thread1 thread = new Thread1(example);
		Thread1 thread1 = new Thread1(example1);
		Thread2 thread2 = new Thread2(example);
		Thread2 thread22 = new Thread2(example1);

//		Thread t1 = new Thread(thread, "t1");
//		Thread t2 = new Thread(thread, "t2");
		Thread t3 = new Thread(thread2, "t3");
		Thread t4 = new Thread(thread22, "t4");

//		t1.start();
//		t2.start();
		t3.start();
		t4.start();
	}

}

class Example
{
	public static synchronized void execute()
	{
		for (int i = 0; i < 10; ++i)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",Hello: " + i);
		}
	}

	public static synchronized void execute2()
	{
		for (int i = 0; i < 10; ++i)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",Hello: " + i);
		}
	}


}

class Thread1 implements Runnable
{
	private Example example;

	public Thread1(Example example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		Example.execute();
	}

}


class Thread2 implements Runnable
{
	private Example example;

	public Thread2(Example example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		Example.execute2();
	}

}
