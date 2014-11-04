/**
 * 
 */
package com.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBManager;
import util.Sql;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-26 上午11:09:18  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-26 上午11:09:18  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement sm = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsm = null;
		try {
			conn = DBManager.getMasterConnection();
			//getInsertRowid(conn, ps, rs, rsm);
			
			updateRS(conn, sm, ps, rs, rsm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Sql.attemptClose(rs);
			Sql.attemptClose(ps);
			Sql.attemptClose(conn);
		}
	}

	
	public static void updateRS(Connection conn, Statement sm, PreparedStatement ps, 
			ResultSet rs, ResultSetMetaData rsm) throws Exception{
		ps = conn.prepareStatement("select uname from zzj_test", 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = ps.executeQuery();
		DatabaseMetaData dm = conn.getMetaData();
		rs = dm.getBestRowIdentifier(null, null, "zzj_test", 1, true);
		while (rs.next()) {
			String name = rs.getString(1);
			System.out.println(name);
			System.out.println();
//			rs.updateString(1, "zzj");
//			rs.updateRow();
//			name = rs.getString(1);
//			System.out.println(name);
		}
	}
	
	public static void getInsertRowid(Connection conn, PreparedStatement ps, 
			ResultSet rs, ResultSetMetaData rsm) throws Exception{
		ps = conn.prepareStatement("insert into zzj_test values ('zzj')", 
				PreparedStatement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		rs = ps.getGeneratedKeys();
		if (rs.next()) {
			String rowid = rs.getString(1);
			System.out.println("rowid = " + rowid);
		}
		
	}
	
	
	public static void metaDataTest(Connection conn, PreparedStatement ps, 
			ResultSet rs, ResultSetMetaData rsm) throws Exception{
		ps = conn.prepareStatement("select * from kb_tag_desc where 1=0");
		rsm = ps.getMetaData();
		int count = rsm.getColumnCount();
		System.out.println("count==" + count);
		for (int i = 1; i <= count; i++) {
			System.out.println("rsm.getCatalogName==" + rsm.getCatalogName(i));
			System.out.println("rsm.getColumnDisplaySize==" + rsm.getColumnDisplaySize(i));
			System.out.println("rsm.getColumnLabel==" + rsm.getColumnLabel(i));
			System.out.println("rsm.getColumnName==" + rsm.getColumnName(i));
			System.out.println("rsm.getColumnType==" + rsm.getColumnType(i));
			System.out.println("rsm.getColumnTypeName==" + rsm.getColumnTypeName(i));
			System.out.println("rsm.getPrecision==" + rsm.getPrecision(i));
			System.out.println("rsm.getScale==" + rsm.getScale(i));
			System.out.println("rsm.getSchemaName==" + rsm.getSchemaName(i));
			System.out.println("rsm.getTableName==" + rsm.getTableName(i));
			System.out.println("---------------------------------------------");
		}
	}
	
	
}
