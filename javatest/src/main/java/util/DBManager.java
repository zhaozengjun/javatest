/**
 * 
 */
package util;

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
			Connection conn = DriverManager.getConnection(Sql.getSql("SLAVE_ORACLE_URL"),Sql.getSql("SLAVE_ORACLE_USER"),Sql.getSql("SLAVE_ORACLE_PWD"));
			DriverManager.setLoginTimeout(5);
			conn.setAutoCommit(false);
			Sql.log.debug("Connection_"+Sql.getSql("SLAVE_ORACLE_URL")+"_SUCCESS");
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
	//主库  
	public static Connection getMasterConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn1 = DriverManager.getConnection(Sql.getSql("MASTER_ORACLE_URL"),Sql.getSql("MASTER_ORACLE_USER"),Sql.getSql("MASTER_ORACLE_PWD"));
			DriverManager.setLoginTimeout(5);
			conn1.setAutoCommit(false);
			Sql.log.debug("Connection_"+Sql.getSql("MASTER_ORACLE_URL")+"_SUCCESS");
			return conn1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//MYSQL 
	public static Connection getMysqlConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn3 = DriverManager.getConnection(Sql.getSql("MYSQL_URL"),Sql.getSql("MYSQL_USER"),Sql.getSql("MYSQL_PWD"));
			DriverManager.setLoginTimeout(5);
			conn3.setAutoCommit(false);
			Sql.log.debug("Connection_"+Sql.getSql("MYSQL_URL")+"_SUCCESS");
			return conn3;
		} catch (Exception e) {
		
			throw new RuntimeException(e);
		}
	}	
	
	/*
	public static void main(String[] args) throws Exception {
		
		Connection conn = DBManager.getConnection3();
		conn.setAutoCommit(false);
		 PreparedStatement pstmt=conn.prepareStatement("select *from sup_recommend");
		 ResultSet rs=pstmt.executeQuery();
		 while(rs.next()){
			 System.out.println(rs.getString(1));
		 }
		 
		
	}
	*/
}
