/**
 * 
 */
package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBManager;
import util.Sql;

/**  
 * @ProjectName：javatest  
 * @TypeName：KBTest1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-6 上午11:00:57  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-6 上午11:00:57  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class KBTest1 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		tagrel();
	}

	
	public static void tagrel(){
		String sql = Sql.getSql("SQL_TAG_REL");
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DBManager.getMasterConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {
				String tagname = rs.getString("tag_name");
				String tagid = rs.getString("tag_id");
				sb.append(" SELECT '")
				.append(tagname)
				.append("' tag_name, '")
				.append(tagid)
				.append("' tag_id FROM dual \n")
				.append(" union all \n ");
			}
			System.err.println(sb);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Sql.attemptClose(rs);
			Sql.attemptClose(ps);
			Sql.attemptClose(connection);
		}
	}
	
}
