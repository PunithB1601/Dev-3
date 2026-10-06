package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Emp{
	Integer eid;
	String fname;
	String lname;
	String job;
	Double sal;
	Integer dno;
	String dname;
	String deptLoc;  
	String city;
	String state;
	
	public Emp() {
		
	}

	public Emp(Integer eid, String fname, String lname, String job, Double sal, Integer dno, String dname,
			String deptLoc, String city, String state) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		this.sal = sal;
		this.dno = dno;
		this.dname = dname;
		this.deptLoc = deptLoc;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", job=" + job + ", sal=" + sal + ", dno="
				+ dno + ", dname=" + dname + ", deptLoc=" + deptLoc + ", city=" + city + ", state=" + state + "]";
	}	
	
	
}

class FetchDataFromDB{
	
	
	public static List<Emp> getData(){
		Emp e=null;
		List<Emp> empList=new ArrayList<Emp>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1", "root", "tiger");
			
			String query=
					"SELECT *"
					+ "FROM EMP E1 JOIN DEPT D1"
					+ " ON E1.DNO=D1.DNO JOIN LOCATION L1"
					+ " ON D1.LID=L1.LID";
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Emp();
				e.eid=rs.getInt("eid");
				e.fname=rs.getString("fname");
				e.lname=rs.getString("lname");
				e.job=rs.getString("job");
				e.sal=rs.getDouble("sal");
				e.dno=rs.getInt("dno");
				e.dname=rs.getString("dname");
				e.deptLoc=rs.getString("location");
				e.city=rs.getString("city");
				e.state=rs.getString("state");
				empList.add(e);
			}
			
			
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return empList;
	}
	
}




public class Test2 {
	
	public static void main(String[] args) {
		List<Emp> eList=FetchDataFromDB.getData();
		
		// 1. WAP to display the emp data if the job role is salesman
	
		/**
				Stream<Emp> s1=eList.stream();
				//Creation of Stream
				Predicate<Emp> p1=(e)->e.job.equals("Salesman");  //Creation of Condition using Predicate
				Stream<Emp> s2=s1.filter(p1); //Passing predicate(condition) inside filter()
				s2.forEach(System.out::println);
		**/		
				eList.stream().filter((e)->e.job.equals("Salesman")).forEach(System.out::println);
		
				System.out.println("=====================");
		//2. WAP to display the emp records if the emp fname is Aman.
				
				eList.stream().filter((e)->e.fname.equalsIgnoreCase("Aman")).forEach(System.out::println);
				
				System.out.println("=====================");
		//3. WAP to display the emp records if the emp getting sal more than 45000.
				
				eList.stream().filter((e)->e.sal>45000.0).forEach(System.out::println);
				
				System.out.println("=====================");
		//4. WAP to display the emp records whose fname starts 'S'.
				
				eList.stream().filter((e)->e.fname.startsWith("S")).forEach(System.out::println);
				
				System.out.println("=====================");
		//5. WAP to display the emp records if the emp is working in Koramangala.
				
				eList.stream().filter((e)->e.deptLoc.equalsIgnoreCase("koramangala")).forEach(System.out::println);
				
				System.out.println("=====================");
		//6. WAP to dislay the emp records if the emp is working in chennai city.
				
				eList.stream().filter((e)->e.city.equalsIgnoreCase("chennai")).forEach(System.out::println);
				System.out.println("=====================");
				
		//7. WAP to display the emp records if the emp is getting sal more than 35000 but less than 70000.
				
				eList.stream().filter((e)->e.sal>35000.0&&e.sal<70000.0).forEach(System.out::println);
				
				System.out.println("=====================");
		//8. WAP to display the emp records who is getting sal more than 30000 and working in IT dept.
				
				eList.stream().filter((e)->e.sal>30000.0&&e.dname.equalsIgnoreCase("IT")).forEach(System.out::println);
	}
}
