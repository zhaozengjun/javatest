/**
 * 
 */
package com.file;

import java.io.File;

/**  
 * @ProjectName：javatest  
 * @TypeName：RenameBySurfix  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class RenameBySurfix {

	public static void main(String[] args) {
		String string = "E:\\works\\vpe\\报表brt文件\\reports";
		rename(string, ".txt");
	}
	
	public static void rename(File file, String surfix){
		if (file.exists()) {
			if (file.isFile()) {
				file.renameTo(new File(file.getParent() + File.separator + 
						file.getName().replaceAll("\\..+", ".txt")));
			}else {
				for (File file2 : file.listFiles()) {
					rename(file2, surfix);
				}
			}
		}else {
			System.out.println("文件或目录不存在");
		}
	}
	
	
	
	public static void rename(String filepath, String surfix){
		rename(new File(filepath), surfix);
	}
}
