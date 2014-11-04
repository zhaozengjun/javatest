/**
 * 
 */
package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 
* @ProjectName：CNTVKB  
* @TypeName：CommonUtil  
* @TypeDesc：  通用工具类
* @author：zhao_zengjun  
* @creatDate：2013-11-2 下午2:55:20  
* @creater：zhao_zengjun  
* @updateDate：2013-11-2 下午2:55:20  
* @updater：zhao_zengjun  
* @version   
*
 */
public class KBUtil {

	private static HanyuPinyinOutputFormat defaultFormat;
	private static String regEx_html = "<[^>]*>"; 
	
	 /**
     * 缺省的日期显示格式： yyyy-MM-dd,作为路径的一部分使用
     */
    public static final String DEFAULT_DATE_FILEPATH_FORMAT = "yyyyMMdd";
    
    public static final String DEFAULT_DATE_FILENAME_FORMAT = "yyyyMMddHHmmss";
    /**
     * 缺省的日期显示格式： yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	
	public static long getRandom(long longValue){
		return Math.round(Math.random() * longValue);
	}
	
	

	
	/********************* 字符串工具  begin *********************/
	
	
	public static String sqlLikeString(String srcString){
		srcString = toString(srcString);
		srcString = srcString.replace("/", "//");
		srcString = srcString.replace("_", "/_");
		srcString = srcString.replace("%", "/%");
		srcString = srcString.replace("'", "''");
//		srcString = srcString.replace("&", "&&");
		return srcString;
	}
	
	
	/**
	 * 截取字符串
	* @author：zhao_zengjun  
	* @Title: substring
	* @param s 源字符串
	* @param t 查找目标
	* @param isPrefix 是否截取前半部分
	* @return
	* String
	* @throws
	 */
	public static String substring(String s, String t, boolean isPrefix){
		String result = KBUtil.toString(s);
		if (s.indexOf(t) < 0) {
			return result;
		}else{
			if (isPrefix) {
				return result.substring(0, s.indexOf(t));
			}else{
				return result.substring(s.indexOf(t));
			}
		}
	}
	
	public static String substring(String s, String t){
		return substring(s, t, true);
	}
	
	public static String removeLastChar(String str){
		if (KBUtil.isBlank(str)) {
			return "";
		}else{
			return str.substring(0, str.length()-1);
		}
	}
	

	public static StringBuffer removeLastChar(StringBuffer str){
		return new StringBuffer(removeLastChar(str.toString()));
	}
	
	
	
	/**
	 * 删除str指定的后缀
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public static String removeSuffix(String str, String suffix)
			throws Exception {
		if (null == str)
			return null;
		if ("".equals(str.trim()))
			return "";

		if (null == suffix || "".equals(suffix))
			return str;

		if (str.endsWith(suffix)) {
			return str.substring(0, str.length() - suffix.length());
		}

		throw new Exception(str + " 没有按指定字符串" + suffix + "结尾");
	}

	/**
	 * 按长度截取字符串
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String subString(String str, int length) {
		if (isBlank(str)) {
			return "";
		} else if (str.length() > length) {
			return str.substring(0, length);
		} else {
			return str;
		}
	}

	public static String subStringSurfix(String str, int length) {
		if (isBlank(str)) {
			return "";
		} else if (str.length() > length) {
			return str.substring(0, length) + "...";
		} else {
			return str;
		}
	}
	
	/**
	 * 是否是空的（包括null、""、空格）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (null == str)
			return true;
		if ("".equals(str.trim()))
			return true;

		return false;
	}

	public static boolean isBlank(Long str) {
		if (null == str)
			return true;
		return false;
	}

	/**
	 * 将对象转成String
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString().trim();
	}
	
	/**
	 * 将对象转换成字符串，可设置默认值
	* @author：zhao_zengjun  
	* @Title: toString
	* @param obj
	* @param defaultValue
	* @return
	* String
	* @throws
	 */
	public static String toString(Object obj, String defaultValue) {
		if (obj == null) {
			return toString(defaultValue);
		}
		return obj.toString().trim();
	}
	
	
	public static <T> boolean isBlank(List<T> list) {
		return list == null || list.size() == 0?true:false;
	}
	
	

	public static String add(String str, int num) {
		int i = num;
		if (!isBlank(str)) {
			int intStr = Integer.parseInt(str);
			i = i + intStr;
		}

		return Integer.toString(i);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if (null == str)
			return "";
		return str;

	}

	/**
	 * Relace all the tags in the StringBuffer object.
	 * 
	 * @param sb
	 *            the StringBuffer object, required
	 * @param from
	 *            the tag string for search, ie.{tag name}, {1}, required
	 * @param to
	 *            the replacement string, cannot be null but may be empty
	 * @return the StringBuffer passed into the method
	 */
	public static StringBuffer replaceTag(StringBuffer sb, String from,
			String to) {
		if (null == sb || null == from || null == to
				|| from.trim().length() == 0) {
			return sb;
		}

		int pos = 0;
		while ((pos = sb.indexOf(from, pos)) != -1) {
			sb.replace(pos, pos + from.trim().length(), to);
			pos += from.trim().length();
		}

		return sb;
	}

	/**
	 * 计算两个数字字符串的和
	 * 
	 * @param augend
	 * @param addend
	 * @return
	 */
	public static String getSum(String augend, String second, String addend) {
		if (augend == null)
			augend = "0";
		if (second == null)
			second = "0";
		if (addend == null)
			addend = "0";
		int sum = Integer.parseInt(augend) + Integer.parseInt(second)
				+ Integer.parseInt(addend);
		return new Integer(sum).toString();
	}

	public static String change(String str, int n, boolean isLeft) {
		if (str == null || str.length() >= n)
			return str;
		String s = "";
		for (int i = str.length(); i < n; i++)
			s += "0";
		if (isLeft)
			return s + str;
		else
			return str + s;
	}

	public static String getInString(String str) {
		if (str == null)
			return null;
		StringBuffer sb = new StringBuffer("");
		String s[] = str.split(",");
		if (s != null && s.length > 0) {
			for (int i = 0; i < s.length; i++) {
				if (i != 0)
					sb.append(",");
				sb.append("'").append(s[i]).append("'");
			}
		}
		return sb.toString();
	}

	public static String subInStringByFlag(String str, String flag) {
		if (isBlank(str))
			return null;
		StringBuffer sb = new StringBuffer(str);
		int index = str.lastIndexOf(flag);
		if (index < 0) {
			return str;
		} else {
			str = sb.delete(sb.length() - flag.length(), sb.length())
					.toString();
			index = str.indexOf(flag);
			if (index < 0) {
				return str;
			} else {
				return sb.deleteCharAt(0).toString();
			}
		}
	}

	/**
	 * 根据标识获取str中最后一个flag后的内容
	 * 
	 * @param str
	 * @param flag
	 * @return
	 */
	public static String getLastStr(String str, String flag) {
		if (isBlank(str))
			return null;
		int index = str.lastIndexOf(flag);
		if (index < 0) {
			return str;
		} else {
			return str.substring(index + flag.length());
		}

	}

	/**
	 * 获取正则表达式匹配的字符串，将$符处理一下，不然匹配时会认作分组
	 * 
	 * @param str
	 * @return
	 */
	public static String getRegexStr(String str) {
		String ret = "";
		if (isBlank(str))
			return "";
		if (str.indexOf('$', 0) > -1) {
			while (str.length() > 0) {
				if (str.indexOf('$', 0) > -1) {
					ret += str.subSequence(0, str.indexOf('$', 0));
					ret += "\\$";
					str = str.substring(str.indexOf('$', 0) + 1, str.length());
				} else {
					ret += str;
					str = "";
				}
			}

		} else {

			ret = str;
		}

		return ret;

	}

	/**
	 * 根据正则表达式截取匹配的字符串列表 从指定字符串中，按正则表达式要求，找出其中能匹配上的字符串列表
	 * 
	 * @param str
	 * @param regx
	 * @return
	 */
	public static List catchStr(String str, String regx) {
		if (isBlank(str))
			return null;

		List ret = new ArrayList();
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(str);
		int start = 0;
		int end = 0;
		while (matcher.find()) {
			start = matcher.start();
			end = matcher.end();
			ret.add(str.substring(start, end));
		}
		return ret;

	}

	/**
	 * 过滤换行符
	 * 
	 * @param str
	 * @return
	 */
	public static String filterNextLine(String str) {
		if (isBlank(str))
			return "";
		return str.replaceAll("[\n\r\u0085\u2028\u2029]", "");
	}

	public static String convertStringEnc(String strSource, String strEncoding)
			throws UnsupportedEncodingException {
		String strResult = new String(strSource.getBytes("ISO-8859-1"),
				strEncoding);
		return strResult;
	}

	/**
	 * 提供字符串两端空格的截取功能，包括两端的全角空格。
	 * 
	 * @param src
	 * @return 截取两端空格之后的字符串
	 */
	public static String trim(String src) {
		if (src == null)
			return null;

		// 把全角空格替换成半角空格
		// src = src.replaceAll(" ", " ");
		char fullSpace = '　';
		char halfSpace = ' ';
		int headIndex = 0;
		int tailIndex = 0;
		int len = src.length();
		for (int i = 0; i < len; i++) {
			char tmp = src.charAt(i);
			if (tmp == fullSpace || tmp == halfSpace) {
				headIndex++;
			} else {
				break;
			}
		}

		for (int i = (len - 1); i >= 0; i--) {
			char tmp = src.charAt(i);
			if (tmp == fullSpace || tmp == halfSpace) {
				tailIndex++;
			} else {
				break;
			}
		}

		// 如果全部都是由半角或者全角空格组成，那么返回空字符串
		if (headIndex == len)
			return "";

		String result = src.substring(headIndex, len - tailIndex);

		return result;
	}

	public static String[] StringBuffer2String(StringBuffer[] str) {
		String[] temp = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			temp[i] = str[i].toString();
		}
		return temp;
	}

	/**
	 * 
	 * Description: 正整数校验<br>
	 * 
	 * @param num
	 * @return
	 */
	public static boolean checkPositiveInteger(String num) {
		String str = "^\\d*[1-9]\\d*$";
		Pattern pattern = Pattern.compile(str);
		return pattern.matcher(num).matches();
	}

	/**
	 * 
	 * Description: 自然数校验<br>
	 * 
	 * @param num
	 * @return
	 */
	public static boolean checkNaturalNumber(String num) {
		String str = "^\\d*[0-9]\\d*$";
		Pattern pattern = Pattern.compile(str);
		return pattern.matcher(num).matches();
	}
	

	/**
	 * 替换特殊字符，kindeditor编辑器专用
	* @author：zhao_zengjun  
	* @Title: htmlspecialchars
	* @param str
	* @return
	* String
	* @throws
	 */
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	
	
	/**
	 * 随机生成字符串
	* @author：zhao_zengjun  
	* @Title: getRandomString
	* @param length
	* @return
	* String
	* @throws
	 */
    public static String getRandomString(int length) { 
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }     
	
	
    public static String getToken(){
    	return getRandomString(16);
    }
    
    
    public static String removeTag(String tag){
    	if (tag == null) {
			return "";
		}
    	Pattern p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
		Matcher m_html = p_html.matcher(tag); 
		tag = m_html.replaceAll(""); //过滤html标签 
    	return tag;
    }
    
    
	
	
	/********************* 字符串工具  end *********************/
	
	
	
	
	
	/********************* 汉字转拼音 begin *********************/
	
	/**
	 * 获取汉字串拼音，英文字符不变
	 * 
	 * @param str
	 *            汉字串
	 * @return 汉语拼音
	 */
	public static String getSpell(String str) {
		if (null == str || str.length() == 0) {
			return "";
		}
		StringBuffer pybf = new StringBuffer();
		char[] arr = str.toCharArray();

		HanyuPinyinOutputFormat defaultFormat = getFormatInstance();

		try {
			for (int i = 0; i < arr.length; i++) {
				if (Character.toString(arr[i]).matches("[\\u4E00-\\u9FA5]+")) {
					pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i],
							defaultFormat)[0]);
				} else {
					pybf.append(arr[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return pybf.toString();
	}

	private static/* synchronized */HanyuPinyinOutputFormat getFormatInstance() {
		if (null == defaultFormat) {
			defaultFormat = new HanyuPinyinOutputFormat();
			defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		}
		return defaultFormat;
	}

	/**
	 * 获取首字母的大写,参数可以是汉字 或 英文 或 符号
	 * 
	 * @param str
	 *            字串
	 * @return 大写首字母
	 */
	public static String getFirstUpperLetter(String str) {
		if (null == str || str.length() == 0) {
			return "";
		}
		String fisrtLetter = "";
		char f = str.charAt(0);
		if (Character.toString(f).matches("[\\u4E00-\\u9FA5]+")) {
			HanyuPinyinOutputFormat defaultFormat = getFormatInstance();
			try {
				fisrtLetter = Character
						.toString(
								PinyinHelper.toHanyuPinyinStringArray(f,
										defaultFormat)[0].charAt(0))
						.toUpperCase();
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		} else {
			fisrtLetter = Character.toString(f).toUpperCase();
		}
		return fisrtLetter;
	}
	

	/********************* 汉字转拼音 end *********************/
	
	
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static String getFileSeperater(){
		return System.getProperty("file.separator");
	}
	
	
	/*******************  json操作     begin      **********************/
	
	
	public static <T> T jsonObjToJava(String jsonStr, Class<T> clazz) {
		try {
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			T retObj = gson.fromJson(jsonStr, clazz);
			return retObj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static <T> T jsonObjToJava(JsonReader reader,Type type) {
		try {
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			T retObj = gson.fromJson(reader, type);
			reader.close();
			return retObj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static <T> T jsonObjToJava(JsonReader reader,Class<T> clazz) {
		try {
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			T retObj = gson.fromJson(reader, clazz);
			reader.close();
			return retObj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public static <T> T jsonToJava(String jsonStr, Class<T> clazz) {
		try {
			String destr = URLDecoder.decode(jsonStr, "UTF-8");
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			T retObj = gson.fromJson(destr, clazz);
			return retObj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static <T> T jsonToJava(String jsonStr, Type type) {
		try {
			String destr = URLDecoder.decode(jsonStr, "UTF-8");
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			T retObj = gson.fromJson(destr, type);
			return retObj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static <T> List<T> jsonArrayToJava(String jsonStr, Type type) {
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		List<T> retList = gson.fromJson(jsonStr, type);
		return retList;
	}
	
	
	public static String javaToJson(Object obj, Type type) {
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		String jsonStr = gson.toJson(obj, type);
		return jsonStr;
	}

	public static void javaToJson(Object obj, Type type, JsonWriter writer) throws IOException {
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		gson.toJson(obj, type, writer);
		writer.flush();
		writer.close();
	}
	

	/*******************  json操作     end      **********************/
	
	
	
	/*******************  日期操作     begin      **********************/
	
	
	/**
	 * 获得当前时间，Timestamp格式
	* @author：zhao_zengjun  
	* @Title: getTimestamp
	* @return
	* Timestamp
	* @throws
	 */
	public static Timestamp getTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
	
	

    /**
     * 得到系统当前日期时间
     * 
     * @return 当前日期时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }
    
    /**
     *  
     * 获得当前日期 yyyy-MM-dd
     * @return
     * Dec 9, 20113:19:32 PM
     * @author niujingwei
     */
    public static Date getNowDate(){
    	return parse(getDate(), DEFAULT_DATE_FORMAT);
    }
    

    
    /**
     *  
     * 获得当前日期 yyyy-MM-dd
     * @return
     * Dec 9, 20113:19:32 PM
     * @author niujingwei
     */
    public static Date getNowDateTime(){
    	return parse(getDateTime(), DEFAULT_DATETIME_FORMAT);
    }
    
    

    /**
     * 将一个字符串用给定的格式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     * 
     * @param datestr 需要解析的日期字符串
     * @param pattern 日期字符串的格式，默认为“yyyy-MM-dd”的形式
     * @return 解析后的日期
     */
    public static Date parse(String datestr, String pattern) {
        Date date = null;

        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATE_FORMAT;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(datestr);
        } catch (ParseException e) {
            //
        }

        return date;
    }

    

    /**
     * 得到用缺省方式格式化的当前日期
     * yyyy-MM-dd
     * @return 当前日期
     */
    public static String getDate() {
        return getDateTime(DEFAULT_DATE_FORMAT);
    }

    /**
     * 得到用缺省方式格式化的当前日期及时间
     * yyyy-MM-dd HH:mm:ss
     * @return 当前日期及时间
     */
    public static String getDateTime() {
        return getDateTime(DEFAULT_DATETIME_FORMAT);
    }
    
    public static String getFilePathDate() {
        return getDateTime(DEFAULT_DATE_FILEPATH_FORMAT);
    }
    
    public static String getFileNameDate() {
        return getDateTime(DEFAULT_DATE_FILENAME_FORMAT);
    }

    /**
     * 得到系统当前日期及时间，并用指定的方式格式化
     * 
     * @param pattern 显示格式
     * @return 当前日期及时间
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        return getDateTime(datetime, pattern);
    }

    /**
     * 得到用指定方式格式化的日期
     * 
     * @param date 需要进行格式化的日期
     * @param pattern 显示格式
     * @return 日期时间字符串
     */
    public static String getDateTime(Date date, String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

	
	
	
	
	
	
	
	
	
	
	/*******************  日期操作     end      **********************/
	
	
	
	
	
	
	
	
	/*******************  文件操作     begin      **********************/
	
	
	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static boolean delFile(String filePathAndName) {
		File myDelFile = new java.io.File(filePathAndName);
		if (!myDelFile.exists()) {
			return true;
		}
		return myDelFile.delete();
	}

	
	/**
	 * 删除指定文件路径下面的所有文件和文件夹
	 * 
	 * @param file
	 */
	public static boolean delFiles(File file) {
		boolean flag = false;
		try {
			if (file.exists()) {
				if (file.isDirectory()) {
					String[] contents = file.list();
					for (int i = 0; i < contents.length; i++) {
						File file2X = new File(file.getAbsolutePath() + "/" + contents[i]);
						if (file2X.exists()) {
							if (file2X.isFile()) {
								flag = file2X.delete();
							} else if (file2X.isDirectory()) {
								delFiles(file2X);
							}
						} else {
							throw new RuntimeException("File not exist!");
						}
					}
				}
				flag = file.delete();
			} else {
				throw new RuntimeException("File not exist!");
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * 判断文件名是否已经存在，如果存在则在后面+(n)的形式返回新的文件名，否则返回原始文件名 例如：已经存在文件名 log4j.htm
	 * 则返回log4j(1).htm
	 * 
	 * @param fileName
	 *            文件名
	 * @param dir
	 *            判断的文件路径
	 * @return 判断后的文件名
	 */
	public static String checkFileName(String fileName, String dir) {
		boolean isDirectory = new File(dir + fileName).isDirectory();
		if (isFileExist(fileName, dir)) {
			int index = fileName.lastIndexOf(".");
			StringBuffer newFileName = new StringBuffer();
			String name = isDirectory ? fileName : fileName.substring(0, index);
			String extendName = isDirectory ? "" : fileName.substring(index);
			int nameNum = 1;
			while (true) {
				newFileName.append(name).append("(").append(nameNum).append(")");
				if (!isDirectory) {
					newFileName.append(extendName);
				}
				if (isFileExist(newFileName.toString(), dir)) {
					nameNum++;
					newFileName = new StringBuffer();
					continue;
				}
				return newFileName.toString();
			}
		}
		return fileName;
	}

	
	/**
	 * 判断文件是否存在
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static boolean isFileExist(String fileName, String dir) {
		File files = new File(dir + fileName);
		return (files.exists()) ? true : false;
	}

	
	
	/**
	 * 返回上传的结果，成功与否
	 * 
	 * @param uploadFileName
	 * @param savePath
	 * @param uploadFile
	 * @return
	 */
	public static boolean upload(String uploadFileName, String savePath, File uploadFile) {
		boolean flag = false;
		try {
			uploadForName(uploadFileName, savePath, uploadFile);
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * 上传文件并返回上传后的文件名
	 * 
	 * @param uploadFileName
	 *            被上传的文件名称
	 * @param savePath
	 *            文件的保存路径
	 * @param uploadFile
	 *            被上传的文件
	 * @return 成功与否
	 * @throws IOException
	 */
	public static String uploadForName(String uploadFileName, String savePath, File uploadFile) throws IOException {
		String newFileName = checkFileName(uploadFileName, savePath);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(new File(savePath, uploadFileName));
			fis = new FileInputStream(uploadFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				throw e;
			}
		}
		return newFileName;
	}

	
	/**
	 * 根据路径创建一系列的目录
	 * 
	 * @param path
	 */
	public static boolean mkDirectory(String path) {
		File file = null;
		try {
			file = new File(path);
			if (!file.exists()) {
				return file.mkdirs();
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			file = null;
		}
		return false;
	}
	
	
	/**
	 * 获得文件名和后缀名
	* @author：zhao_zengjun  
	* @Title: getSplitFileName
	* @param fileName
	* @return
	* String[]
	* @throws
	 */
	public static String[] getSplitFileName(String fileName){
		String[] strings = new String[2];
		if (!KBUtil.isBlank(fileName)) {
			int pos = fileName.indexOf(".");
			if (pos < 0) {
				strings[0] = fileName;
			}else {
				strings[0] = fileName.substring(0, pos);
				strings[1] = fileName.substring(pos);
			}
		}
		return strings;
	}
	
	
	

	public static String codeString(File file) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(file), 20);
		int p = (bin.read() << 8) + bin.read();
		String code = null;

		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}
		bin.close();
		return code;
	}

	

	public static String codeString(String filepath) throws Exception{
		return codeString(new File(filepath));
	}
    
	
	
	
	
	/*******************  文件操作     end      **********************/
	
	
	
	/*******************  数据库操作     start      **********************/
	
	
	public static String getOrderByPinyin(String column){
		String order = "''";
		if (!KBUtil.isBlank(column)) {
			order = " nlssort(" + column + ",'NLS_SORT=SCHINESE_PINYIN_M')";
		}
		return order;
	}
	
	
	
	
	
	
	
	
	
	/*******************  数据库操作     end      **********************/
	
	
	
	public static void showSet(Set set){
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getRandomString(22));
	}
	
	
	
	
}
