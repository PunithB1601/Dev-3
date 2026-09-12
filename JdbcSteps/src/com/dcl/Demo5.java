package com.dcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","tiger");
			PreparedStatement ps=con.prepareStatement("UPDATE STUDENT SET PHONE=? WHERE ID=?");
			System.out.println("Enter the Id:");
			Integer id=sc.nextInt();
			System.out.println("Enter the Phone:");
			String phone=sc.next();
			
			ps.setString(1, phone);
			ps.setInt(2, id);
			
			int status=ps.executeUpdate();
			if(status>0) {
				System.out.println("Phone Updated");
			}
			else {
				System.out.println("Failed to update");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
