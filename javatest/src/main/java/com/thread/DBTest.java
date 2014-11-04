/**
 * 
 */
package com.thread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**  
 * @ProjectName：javatest  
 * @TypeName：DBTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-11 上午11:23:10  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-11 上午11:23:10  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class DBTest {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {

		try {
			Connection connection = DBManager.getSlaveConnection();
			String sql = "SELECT * FROM kb_videoinfo";
			PreparedStatement ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = ps.executeQuery();
			System.out.println(resultSet.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
