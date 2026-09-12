package com.dcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","tiger");
			String query="SELECT * FROM STUDENT WHERE EMAIL=? AND PASSWORD=?";
			PreparedStatement ps=con.prepareStatement(query);
		
			System.out.println("Enter the Email:");
			String email=sc.next();
			System.out.println("Enter the Password:");
			String password=sc.next();
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" || "+rs.getString("name"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
