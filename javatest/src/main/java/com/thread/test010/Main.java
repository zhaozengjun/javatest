/**
 * 
 */
package com.thread.test010;

import java.lang.reflect.Field;

/**  
 * @ProjectName：javatest  
 * @TypeName：Main  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 下午2:16:25  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 下午2:16:25  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Main {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main (String[] args) throws Exception {
        Class cache = Integer.class.getDeclaredClasses ()[0];
        Field c = cache.getDeclaredField ("cache");
        c.setAccessible (true);
        Integer[] array = (Integer[]) c.get (cache);
        array[132] = array[133];

        System.out.printf ("%d",2 + 2);
    }

}
