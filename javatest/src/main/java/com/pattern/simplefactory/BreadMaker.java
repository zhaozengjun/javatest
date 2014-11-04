/**
 * 
 */
package com.pattern.simplefactory;

/**  
 * @ProjectName：javatest  
 * @TypeName：BreadMaker  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class BreadMaker {

	public void getBread(int breadType){
		switch (breadType) {
		case 1:
			System.out.println("黑面包");
			break;
		case 2:
			System.out.println("白面包");
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		BreadMaker breadMaker = new BreadMaker();
		breadMaker.getBread(1);
		breadMaker.getBread(2);
	}

}
