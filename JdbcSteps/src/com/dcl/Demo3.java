package com.dcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//PreparedStatement 
public class Demo3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","tiger");
			String query="INSERT INTO STUDENT VALUES (0,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			//collecting the data from the user
			System.out.println("Enter the username");
			String username=sc.next();
			System.out.println("Enter the phone");
			String mobile=sc.next();
			System.out.println("Enter the email");
			String mail=sc.next();
			System.out.println("Enter the password");
			String password=sc.next();
			
			// assigning the data for the placeholders
			ps.setString(1,username);
			ps.setString(2, mobile);
			ps.setString(3, mail);
			ps.setString(4, password);
			
			int i=ps.executeUpdate();
			System.out.println(i);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
