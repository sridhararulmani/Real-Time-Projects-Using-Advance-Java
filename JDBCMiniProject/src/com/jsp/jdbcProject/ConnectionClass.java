package com.jsp.jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stars5",
					"root", 
					"root");			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectionObject() {
		return con;
	}
}