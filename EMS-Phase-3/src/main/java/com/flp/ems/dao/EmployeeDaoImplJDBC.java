package com.flp.ems.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmployeeDaoImplJDBC implements IemployeeDao {
	
	
	 Employee e=new Employee();
	 Department d=new Department();
	 Project p=new Project();
	 Role r=new Role();

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	//private String s;
	
	public void addEmployee(Employee e)
			throws ClassNotFoundException, SQLException {

		// TODO Auto-generated method stub

		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		System.out.println("into data base");
		
		String dq="insert into Department values(?,?)";
		PreparedStatement Stmt=(PreparedStatement) dbConnection.prepareStatement(dq);
		Stmt.setInt(1,e.getDepartment().getDeptid());
		Stmt.setString(2,e.getDepartment().getDeptName());
		Stmt.execute();
		
		String pq="insert into Project values(?,?,?)";
		PreparedStatement St=(PreparedStatement) dbConnection.prepareStatement(pq);
		St.setInt(1,e.getProject().getProjId());
		St.setString(2,e.getProject().getProjName());
		St.setInt(3,e.getDepartment().getDeptid());
		St.execute();
		
		String rq="insert into Role values(?,?)";
		PreparedStatement mt=(PreparedStatement) dbConnection.prepareStatement(rq);
		mt.setInt(1,e.getRole().getRoleId());
		mt.setString(2,e.getRole().getRoleName());
		mt.execute();
		
		String query = "insert into Employee values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt=(PreparedStatement) dbConnection.prepareStatement(query);
		
		preparedStmt.setString(1, e.getKinid());
		preparedStmt.setString(2,e.getEmpid());
		preparedStmt.setString(3, e.getEmpname());
		preparedStmt.setString(4, e.getMail());
		preparedStmt.setString(5, e.getPhoneNo());
		preparedStmt.setString(6, e.getAddress());
		preparedStmt.setString(7,e.getDob());
		preparedStmt.setString(8,e.getDoj());
		preparedStmt.setInt(9,e.getDepartment().getDeptid());
		preparedStmt.setInt(10,e.getProject().getProjId());
		preparedStmt.setInt(11,e.getRole().getRoleId());
		
		preparedStmt.execute();
		//Stmt.executeUpdate(query);
	}

	public void getAllEmployee() throws ClassNotFoundException,SQLException
	{
		 Class.forName(driver);
		 Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		 java.sql.Statement stmt = dbConnection.createStatement();
		    java.sql.ResultSet rs = stmt.executeQuery("select * from Employee inner join Department on Employee.deptid=Department.deptid inner join Role on Employee.roleId=Role.roleId inner join Project on Employee.projId=Project.projId");
		    

		   
		    while (rs.next()) 
		    {
		    	    	 
		         System.out.println("empid: "+rs.getString("empid"));
		         System.out.println("kinid: "+rs.getString("kinid"));
		         System.out.println("empname: "+rs.getString("empname"));
		         System.out.println("mail: "+rs.getString("mail"));
		         System.out.println("phoneNo: "+rs.getString("phoneNo"));
		         System.out.println("address: "+rs.getString("address"));
		         System.out.println("dob: "+rs.getString("dob"));
		         System.out.println("doj: "+rs.getString("doj"));
		         System.out.println("Deptid: "+rs.getInt("Deptid"));
		         System.out.println("DeptName: "+rs.getString("deptName"));
		         System.out.println("projId: "+rs.getInt("projId"));
		         System.out.println ("projName: "+rs.getString("projName"));
		         System.out.println("roleId: "+rs.getInt("roleId"));
		         System.out.println("roleName: "+rs.getString("roleName"));
		    }
    
	
}

	@Override
	public Employee searchEmployee(String kinid, String empName, String mail) throws ClassNotFoundException, SQLException 
	{   Employee e=new Employee();
		 Class.forName(driver);
		 Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		 //PreparedStatement stmt = (PreparedStatement) dbConnection.prepareStatement("select * from Employee e where e.kinid=? or e.empname=? or e.mail=?");
		 PreparedStatement stmt = (PreparedStatement) dbConnection.prepareStatement("select * from Employee inner join Department on Employee.deptid=Department.deptid inner join Role on Employee.roleId=Role.roleId inner join Project on Employee.projId=Project.projId where kinid=? or empname=? or mail=?");
		 //java.sql.ResultSet rs=stmt.executeQuery("select * from Employee inner join Department on Employee.deptid=Department.deptid inner join Role on Employee.roleId=Role.roleId inner join Project on Employee.projId=Project.projId where kinid=? or empname=? or mail=?"); 
		 stmt.setString(1, kinid);
		 
		 stmt.setString(2, empName);
		  stmt.setString(3, mail);
		  java.sql.ResultSet rs=stmt.executeQuery();
		  int flag=0;
		while(rs.next()){
			 flag=1;
		 e.setEmpid((String)rs.getString("empid"));
		 //System.out.println(rs.getString("empid"));
		 e.setKinid((String)rs.getString("kinid"));
		 e.setEmpname((String)rs.getString("empname"));
		 e.setMail((String)rs.getString("mail"));
		 e.setPhoneNo((String)rs.getString("phoneNo"));
		 e.setAddress((String)rs.getString("address"));
		 e.setDob((String)rs.getString("dob"));
		 e.setDoj((String)rs.getString("doj"));
		 d.setDeptid((int)rs.getInt("deptid"));
		 d.setDeptName((String)rs.getString("deptName"));
		 e.setDepartment(d);
		 p.setProjId((int)rs.getInt("projId"));
		 p.setProjName((String)rs.getString("projName"));
		 e.setProject(p);
		 r.setRoleId((int)rs.getInt("roleId"));
		 r.setRoleName((String)rs.getString("roleName"));
		 e.setRole(r);
		}
		if(flag==0)
		{
			return null;
		}
		 return e;
		}
		
	

	@Override
	public Employee modifyEmployee(Map empModifiedDetails, Employee emp, int ch) throws SQLException, ClassNotFoundException {
		 Class.forName(driver);
		 Connection dbConnection=null;
		 dbConnection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		 PreparedStatement stmt;
	
		
		switch(ch)
		{
		       case 1: //emp.setEmpname((String) empModifiedDetails.get("empName"));
		    	         System.out.println(empModifiedDetails.get("empName"));
		    	            System.out.println(emp.getEmpname());
		    	   
		              stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set empname=? where empname='"+emp.getEmpname()+"'");
		              stmt.setString(1,(String) empModifiedDetails.get("empName"));
		              stmt.executeUpdate();
		              emp.setEmpname((String) empModifiedDetails.get("empName"));
		              break;
		       case 2:emp.setMail((String) empModifiedDetails.get("email"));
		             stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set mail=? where mail='"+emp.getMail()+"'");
		             stmt.setString(1, emp.getMail());
		             stmt.executeUpdate();
				     break;
		       case 3:emp.setPhoneNo((String) empModifiedDetails.get("phoneNo"));
		              stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set phoneNo=? where phoneNo='"+emp.getPhoneNo()+"'");
		             stmt.setString(1, emp.getPhoneNo());
		             stmt.executeUpdate();
		              break;
		       case 4:emp.setAddress((String) empModifiedDetails.get("address"));
		       		stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set address=? where address='"+emp.getAddress()+"'");
	                stmt.setString(1, emp.getAddress());
	                stmt.executeUpdate();
	        		break;
		       	case 5:emp.setDob((String) empModifiedDetails.get("dob"));
		       			stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set dob=? where dob='"+emp.getDob()+"'");
		       			stmt.setString(1,emp.getDob());
		       		 stmt.executeUpdate();
						break;
		       	case 6:emp.setDoj((String) empModifiedDetails.get("doj"));
		       			stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set doj=? where doj='"+emp.getDoj()+"'");
		       			stmt.setString(1,emp.getDoj());
		       		 stmt.executeUpdate();
				        break;
		}
	
		return emp;
		
	}

	@Override
	public boolean removeEmployee(String kinid, String empName, String mail) 
	{
		
		return false;
	}

} 
	



	
	


	
	




	


