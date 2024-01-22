package com.jsp.jdbcProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CURDOptrationsInJDBC extends ConnectionClass {
	public static void printData(ResultSet rs) throws Exception {
		while (rs.next()) {
			System.out.println(rs.getInt("s.no") + "	" + rs.getString("dishes") + "	" + rs.getDouble("price"));
		}
	}
	public static void main(String[] args) {
		String Query = "select * from stars5.menucard where price =	?;";
		Connection con = ConnectionClass.getConnectionObject();
		try {
			Scanner sc = new Scanner(System.in);
			PreparedStatement pstmt = con.prepareStatement(Query);
			System.out.println("Enter the the Price to Search Dishes Avilable in Hotel");
			int price = sc.nextInt();
			pstmt.setInt(1, price);
			ResultSet rs = pstmt.executeQuery();
			printData(rs);
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}