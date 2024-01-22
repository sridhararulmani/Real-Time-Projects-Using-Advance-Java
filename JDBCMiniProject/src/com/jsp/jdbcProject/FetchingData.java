package com.jsp.jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchingData {

	public static void main(String[] args) {
		String fetchQuery="select * from stars5.menucard;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stars5", "root", "root");
			PreparedStatement pstmt=con.prepareStatement(fetchQuery);
			ResultSet result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("s.no")+"-"
						+result.getString("dishes")+"-"
						+result.getDouble("price"));
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
