/**
 * 
 */
package com.file;

import java.io.File;

/**  
 * @ProjectName：javatest  
 * @TypeName：Rename  
 * @TypeDesc：  批量重命名文件，删除文件名的前几个字
 * @author：Administrator  
 * @creatDate：2014-8-19 上午11:38:38  
 * @creater：Administrator  
 * @updateDate：2014-8-19 上午11:38:38  
 * @updater：Administrator  
 * @version   
 *   
 */
public class Rename {

	/**
	 * @author：Administrator  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		String string = "E:\\学习资料\\马士兵\\马士兵_设计模式";
		rename(string, "尚学堂马士兵_");
	}
	
	
	
	public static void rename(File file, String prefix) {
		if (file.exists()) {
			if (file.isFile()) {
				file.renameTo(new File(file.getParent() + File.separator + 
						file.getName().replaceFirst(prefix, "")));
			}else {
				for (File file2 : file.listFiles()) {
					rename(file2, prefix);
				}
			}
		}else {
			System.out.println("文件或目录不存在");
		}
	}
	
	
	
	public static void rename(String filepath, String prefix){
		rename(new File(filepath), prefix);
	}

}
