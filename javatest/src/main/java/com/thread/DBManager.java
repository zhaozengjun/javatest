/**
 * 
 */
package com.thread;

//import java.beans.PropertyVetoException;
//import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import oracle.jdbc.pool.OracleDataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mchange.v2.resourcepool.ResourcePool.Manager;


/**  
 * @ProjectName：CNTVSQL  
 * @TypeName：DBManager  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2013-11-11 下午6:19:46  
 * @creater：zhao_zengjun  
 * @updateDate：2013-11-11 下午6:19:46  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class DBManager{
	
	//从库  
	public static Connection getSlaveConnection()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.18.117.193:1521:standby",
					"cntvvms", "Cn2TV8Vms");
			DriverManager.setLoginTimeout(5);
			conn.setAutoCommit(false);
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
