package util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Sql implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	public static String SqlFileAdress="";
	public static List<Map<String, String>> sqlList = new ArrayList<Map<String, String>>();
	public static Logger log = Logger.getLogger("pro.file");
	/*
	 * 读取log4j.properties
	 * @param key
	 * @return
	 */
	public static String readLog4jValue(String key) {
		Properties props = new Properties();
		InputStream ips = null;
		try {
			ips = Sql.class.getResourceAsStream("/log4j.properties");
			props.load(ips);
			ips.close();
			String value = props.getProperty(key);
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ips != null) {
				try {
					ips.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public static void log4jFile(String fileName){
		String logLevel = Sql.getSql("LOG_LEVEL"); //DEBUG/INFO/ERROR
		  Properties pro=new Properties();	 
		  pro.put("log4j.logger.pro.file", "DEBUG,pro.file.out");
		  pro.put("log4j.appender.pro.file.out", "org.apache.log4j.DailyRollingFileAppender");
		  pro.put("log4j.appender.pro.file.out.File",Sql.readLog4jValue("log4j.appender.pro.file.out.File").trim()+fileName);//可随便修改 F:/test/helloappLoggerlog.txt
		  //  pro.put("log4j.appender.pro.file.out.DatePattern","yyyy-MM-dd'.txt'");
		  pro.put("log4j.appender.pro.file.out.Threshold",logLevel);	//控制输出Level
		  pro.put("log4j.appender.pro.file.out.layout", "org.apache.log4j.PatternLayout");
		  pro.put("log4j.appender.pro.file.out.layout.ConversionPattern","%d{yyyy-MM-dd HH:mm:ss}:[LVL-%-5p]-%m%n");
		  PropertyConfigurator.configure(pro);
		
	}
	//读取sqlfile.xml
		public static String getSql(String sqlId) {	
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			factory.setIgnoringComments(true);
				try {
					builder = factory.newDocumentBuilder();
				
				if(SqlFileAdress.equals("")||SqlFileAdress==null){
					SqlFileAdress=System.getProperty("user.dir");
				}
				Document document = builder.parse(new File(SqlFileAdress+File.separator+"sqlfile.xml"));
				//Document document = builder.parse(SqlCodeBean.class.getResourceAsStream("/sqlfile.xml"));
				Element element = document.getDocumentElement();
				NodeList sqlCodeNodes = element.getElementsByTagName("sql");
				int sqlCodeLength = sqlCodeNodes.getLength();
				for (int i = 0; i < sqlCodeLength; i++) {
					Element sqlCodeNode = (Element) sqlCodeNodes.item(i);
					String sqlName = sqlCodeNode.getAttribute("name");
					String sqlCode = sqlCodeNode.getFirstChild().getNodeValue()
							.toString();
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", sqlName);
					map.put("sqlcode", sqlCode);
					sqlList.add(map);
				}
				for (Map<String, String> map : sqlList) {
					String sqlName = (String) map.get("name");
					if (sqlName.equals(sqlId)) {
						return (String) map.get("sqlcode").trim();
					}

				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sqlId;
		}


	public static long getLongTime(){
		return System.currentTimeMillis();	
	}

	
	
	public static void attemptClose(ResultSet o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void attemptClose(Statement o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void attemptClose(Connection o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void attemptClose(Reader o){
			try {
				if (o != null)
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

}
