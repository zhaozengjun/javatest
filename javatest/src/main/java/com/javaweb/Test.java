/**
 * 
 */
package com.javaweb;

import java.io.UnsupportedEncodingException;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-8-13 下午5:45:06  
 * @creater：zhao_zengjun  
 * @updateDate：2014-8-13 下午5:45:06  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	/**

	 * byte Array toHex

	 * @param b

	 * @return

	 */
	public static String toHex(byte[] b) {

		String result = "";

		for (int i = 0; i < b.length; i++) {

			String hex = Integer.toHexString(b[i] & 0xFF);

			if (hex.length() == 1) {//高四位置为0

				hex = '0' + hex;

			}

			result = result + " " +hex.toUpperCase();

		}

		return result;

	}

	/**

	 * char to byte array

	 * @param c

	 * @return

	 */

	public static byte[] charToByte(char c) {

		byte[] b = new byte[2];

		b[0] = (byte) ((c & 0xFF00) >> 8);

		b[1] = (byte) (c & 0xFF);

		return b;

	}

	/**

	 * char array toHex

	 * @param c

	 */

	public static void charToHex(char[] c){

		for(char cc:c){

			byte[] b =charToByte(cc);

			System.out.print(toHex(b));

		}

	}

	public static void main(String[] args) {

		String name = "I am 君山";

		charToHex(name.toCharArray());

		System.out.println();

		try {

			byte[] iso8859 = name.getBytes("ISO-8859-1");

			System.out.println(toHex(iso8859));

			byte[] gb2312 = name.getBytes("GB2312");

			System.out.println(toHex(gb2312));

			byte[] gbk = name.getBytes("GBK");

			System.out.println(toHex(gbk));

			byte[] utf16 = name.getBytes("UTF-16");

			System.out.println(toHex(utf16));

			byte[] utf8 = name.getBytes("UTF-8");

			System.out.println(toHex(utf8));

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

	}

}
