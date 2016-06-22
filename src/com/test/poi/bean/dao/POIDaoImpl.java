package com.test.poi.bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.poi.bean.Employee;

public class POIDaoImpl implements POIDao {

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		// return getEmployeesList();    JDBC Call  NO DB DETAILS
		return getEmployeeListMock();  // MOCK DATA
	}

	private List<Employee> getEmployeeListMock() {
		
		List<Employee>  list = new ArrayList<Employee>();
		Employee employee = null;
		for(int i=0;i<10;i++){
			employee = new Employee();
			employee.setEno(""+i);
			employee.setEname("name"+i);
			employee.setEage("0"+i);
			list.add(employee);
		}
		
		return list;
	}
	

	   
	   
	   public  List<Employee> getEmployeesList() {
		// JDBC driver name and database URL
		   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   String DB_URL = "jdbc:mysql://localhost/EMP";

		   //  Database credentials
		   String USER = "username";
		   String PASS = "password";
	   Connection conn = null;
	   Statement stmt = null;
	   List<Employee>  list = new ArrayList<Employee>();
		Employee employee = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, name, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String name = rs.getString("name");

	         employee = new Employee();
				employee.setEno(""+id);
				employee.setEname(name);
				employee.setEage(""+age);
				list.add(employee);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   return list;
	   
	}//end main


}
