package com.dcl.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


/** 
 * Stream API
 * 
 * -> Intermediate Methods
 * 		filter()
 * 		map()
 * 		distinct()
 * 		limit()
 * 		skip()
 * 		sorted()
 * 
 * -> Terminal Methods
 * 		Long count()
 * 		Optional findFirst()
 * 		boolean anyMatch()
 * 		boolean allMatch()
 * 		boolean noneMatch()
 */

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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_2", "root", "tiger");
			
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
				
				System.out.println("=====================");
		//9. WAP to display the emp fname and emp lname if the emp fname starts with S or A.
		
		/**		Stream s1=eList.stream();  -- convert List to stream 
				Predicate<Emp> p1=(e)->e.fname.startsWith("S")||e.fname.startsWith("A"); -- creating a condition by using Predicate 
				Stream s2=s1.filter(p1);  -- Applying filter based on the condition written 
				Function<Emp, String> f1=(e)->e.fname+" "+e.lname; -- modifying the content to be displayed 
				Stream s3=s2.map(f1);
				s3.forEach(System.out::println);  **/
				 
				eList.stream().filter((e)->e.fname.startsWith("S")||e.fname.startsWith("A")).map((e)->e.fname+" "+e.lname).forEach(System.out::println);
				
				System.out.println("=====================");
		
		//10. WAP to display the emp fname, job, sal if the emp is working in HR dept.
				
				eList.stream().filter((e)->e.dname.equals("HR")).map((e)->e.fname+" "+e.job+" "+e.sal).forEach(System.out::println);
				
				System.out.println("=====================");
		//11. WAP to display the fullname of all the emp.
				
				eList.stream().map((e)->e.fname+" "+e.lname).forEach(System.out::println);
				
				System.out.println("=====================");
		
		//12. WAP to display the emp names in below format.
				//e.fname=Siddarth e.lname=Patil -> Siddarth.P
				
				eList.stream().map((e)->e.fname+"."+e.lname.substring(0, 1)).forEach(System.out::println);
		
				System.out.println("=====================");
		//13. WAP to display the first half of the fname. 	
				
				eList.stream().map((e)->e.fname.substring(0, e.fname.length()/2)).forEach(System.out::println);
		
				System.out.println("=====================");
		//14. WAP to display the second half of the fname.
	
				eList.stream().map((e)->e.fname.substring(e.fname.length()/2)).forEach(System.out::println);
		
				System.out.println("=====================");
		//15. WAP to display the first half in lower case and second of fname in upper case.
				
				eList.stream().map((e)->e.fname.substring(0, e.fname.length()/2).toLowerCase()+e.fname.substring(e.fname.length()/2).toUpperCase()).forEach(System.out::println);
				
				System.out.println("=====================");
				
	    //16. WAP to display the job roles of emps.
				
				eList.stream().map((e)->e.job).distinct().forEach(System.out::println);
				
				System.out.println("=====================");
				
	    //17. WAP to display the depts in emp List.
				
				eList.stream().map((e)->e.dname).distinct().forEach(System.out::println);
				
				System.out.println("=====================");
	    //18. WAP to display the dept and its Location from emp List.
				
				eList.stream().map((e)->e.dname+" "+e.deptLoc).distinct().forEach(System.out::println);
				
				System.out.println("=====================");
		//19. WAP to display the first 5 emp data from emp List.
				
				eList.stream().limit(5).forEach(System.out::println);
				
				System.out.println("=====================");
				
		//20. WAP to display the first 8 emp data from emp List.
				
				eList.stream().limit(8).forEach(System.out::println);
	    
				System.out.println("=====================");
	    //21. WAP to display the first 3 emp fullnames.
				
				eList.stream().map((e)->e.fname+" "+e.lname).limit(3).forEach(System.out::println);
				
				System.out.println("=====================");
		//22. WAP to display the second record from empList.
				
				eList.stream().skip(1).limit(1).forEach(System.out::println);
				System.out.println("=====================");
				
		//23. WAP to display the 7th record from empList.
				
				eList.stream().skip(6).limit(1).forEach(System.out::println);
				
				System.out.println("=====================");
		//24. WAP to display the 10th and 11th record from empList.
				
				eList.stream().skip(9).limit(2).forEach(System.out::println);
				
				System.out.println("=====================");
		//25.  WAP to display the records in asc order based on empId.
				eList.stream().sorted(Comparator.comparing((Emp e)->e.eid)).forEach(System.out::println);
				
				System.out.println("=====================");
		//26. WAP to display the emp first name in alphabetical order.
				eList.stream().map((e)->e.fname).sorted(Comparator.comparing((fname)->fname)).forEach(System.out::println);
				
				System.out.println("=====================");
		//27. WAP to display the last emp record.
				eList.stream().sorted(Comparator.comparing((Emp e)->e.eid).reversed()).limit(1).forEach(System.out::println);
				
				System.out.println("=====================");
		//28. WAP to display the last 3 emp records.
				eList.stream().sorted(Comparator.comparing((Emp e)->e.eid).reversed()).limit(3).forEach(System.out::println);
			
				System.out.println("=====================");
		//29. WAP to display the names of emps if the emp fname starts with S or K or A and arrange the info 
				//based on names in alphabetical order
				eList.stream()
					 .filter((e)->e.fname.startsWith("S")||e.fname.startsWith("K")||e.fname.startsWith("A"))
					 .map((e)->e.fname)
					 .sorted(Comparator.comparing((fname)->fname))
					 .forEach(System.out::println);
				
				System.out.println("=====================");		
		//30. WAP to display the emp info if the emp is from Karnataka and display the first 3
				//emps from output.
				eList.stream()
					 .filter((e)->e.state.equals("Karnataka"))
					 .limit(3)
					 .forEach(System.out::println);
				
				System.out.println("=====================");	
		//31. WAP to display the emp with even Id.
				eList.stream()
				     .filter((e)->e.eid%2==0)
				     .forEach(System.out::println);
				
				System.out.println("=====================");	
		//32. WAP to display the top 3 salaries from emp List.
				eList.stream()
				     .map(e->e.sal)
				     .sorted(Comparator.comparing((Double sal)->sal).reversed())
				     .distinct()
				     .limit(3)
				     .forEach(System.out::println);
				
				System.out.println("=====================");	
		//33. WAP to display the top 3 min salaries from emp List.
				eList.stream()
			     .map(e->e.sal)
			     .sorted(Comparator.comparing(sal->sal))
			     .distinct()
			     .limit(3)
			     .forEach(System.out::println);   
				
				System.out.println("=====================");	
		//34. WAP to display the number of emps in the empList.
				System.out.println(eList.stream().count());
			//	Long count=eList.stream().count();
			//	System.out.println(count);
				
				System.out.println("=====================");	
	    //35. WAP to display the number of emps who are working as salesman.
				System.out.println(eList.stream().filter(e->e.job.equals("Salesman")).count());
				
				System.out.println("=====================");
		//36. WAP to display the number of emps working in Chennai.
				System.out.println(eList.stream().filter(e->e.city.equals("Chennai")).count());
				
				System.out.println("=====================");
		//37. WAP to display the first emp record from eList.
			//	eList.stream().limit(1).forEach(System.out::println);
				Emp e1=eList.stream().findFirst().orElse(null);
				System.out.println(e1);
				
				System.out.println("=====================");
		//38. WAP to display the first salesman record.
				Emp e2=eList.stream()
							.filter(e->e.job.equals("Salesman"))
							.findFirst()
							.orElse(null);
				System.out.println(e2);
				
				System.out.println("=====================");
		//39. WAP to display the first emp acc to alphabetical order of fname.
				Emp e3=
				eList.stream()
					 .sorted(Comparator.comparing(e->e.fname))
					 .findFirst()
					 .orElse(null);
				System.out.println(e3);
				
				System.out.println("=====================");
	   //40. WAP to check whether any emp belongs to Karnataka or not.
				boolean status=
				eList.stream()
					 .anyMatch(e->e.state.equals("Goa"));
					System.out.println(status); 
				
					System.out.println("=====================");
					
	   //41. WAP to check all the emps belong to Bangalore or not.
					
				
					
	   //42. WAP to check whether any emps  belong to Security Dept or not.
					
	}
	
}
