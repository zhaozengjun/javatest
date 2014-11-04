/**
 * 
 */
package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import util.KBUtil;

/**  
 * @ProjectName：javatest  
 * @TypeName：FileTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-18 下午3:51:41  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-18 下午3:51:41  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class FileTest {
	
	public static void listFiles(File file, List<File> files){
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File file2 : file.listFiles()) {
					listFiles(file2, files);
				}
			}else {
				files.add(file);
			}
		}
	}
	
	public static void main(String[] args) {
		String filepath = "E:\\works\\大屏数据\\sobey媒资csv数据";
		File file = new File(filepath);
		List<File> files = new ArrayList<File>();
	    Set<String> guidSet = new HashSet<String>();
		listFiles(file, files);
		int i = 0;
		for (File file2 : files) {
			analysisFile(file2, guidSet);
			i++;
		}
		for (String string : guidSet) {
			System.out.println(string);
		}
		System.out.println(guidSet.size());
		System.out.println(i);
	}
	
	
	public static void analysisFile(File file, Set<String> guidSet){
	    FileInputStream fis = null;
		InputStreamReader isw = null;
	    CsvListReader csvListReader = null;
	    List<String> strings = null;
		try {
			String code = KBUtil.codeString(file);
			fis = new FileInputStream(file);
			isw = new InputStreamReader(fis, code);
			csvListReader = new CsvListReader(isw, CsvPreference.STANDARD_PREFERENCE);
			while ((strings = csvListReader.read()) != null) {
				guidSet.add(strings.get(0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (csvListReader != null) {
					csvListReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (isw != null) {
					isw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fis != null) {
					isw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
