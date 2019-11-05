package com.cake.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getCon() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeonline_db?useUnicode=true&characterEncoding=utf-8","root","");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*8
	 * 
	 */
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
