package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public  class EmployeeDaoImplForList {

	List<Employee> employees=new ArrayList<Employee>();
	List<Department> departments=new ArrayList<Department>();
	List<Project> projects=new ArrayList<Project>();
	List<Role> roles=new ArrayList<Role>();
	
	HashSet<Employee> empy=new HashSet<Employee>();

	public void addEmployee(Employee emp)
	{
		//if(!employees.contains(emp))//for checking duplicate
       employees.add(emp);
	   /*departments.add(emp.getDepartment());
	   projects.add(emp.getProject());
	   roles.add(emp.getRole());
	   */
      //empy.add(emp);
	  // System.out.println(empy);
	   System.out.println(emp);
    }
	
	
	
	public boolean removeEmployee(String kinid, String empName, String mail) {
	
		for (Employee emp : employees) {
		       if (emp.getKinid().equals(kinid)){
		          employees.remove(emp);
		          return true;
		       }
		       else if(emp.getEmpname().equals(empName))
				{
		          employees.remove(emp);
			      return true;
			    }
				  
			   else if(emp.getMail().equals(mail))
			    {
				   employees.remove(emp);
			       return true;
			    }
		 }
		return false;
	}
		

public Employee searchEmployee(String kinid,String empName,String mail) {
	for(Employee e:employees)
	{
		 if(e.getEmpname().equals(empName))
		{
			System.out.println("Name found ");
		    return e;			
		}
		  
		 else if( e.getMail().equals(mail))
			{
			  	System.out.println("Mail found ");
				return e;
				
			}
		 else if( e.getKinid().equals(kinid))
			{
				System.out.println(" Kinid found");
				return e;
			}	
			
		 else if(e.getEmpname().equals(empName) && e.getMail().equals(mail) && e.getKinid().equals(kinid))
			{
				System.out.println("name,email id and kin id found");
				return e;
			}
		 else if(e.getEmpname().equals(empName) && e.getMail().equals(mail))
			{
				System.out.println("name,email id found");
			    return e;
			}
		 else if( e.getMail().equals(mail) && e.getKinid().equals(kinid))
			{
				System.out.println("email id and kin id found");
			    return e;
			}
		 else if(e.getEmpname().equals(empName)  && e.getKinid().equals(kinid))
			{
				System.out.println("match found for name and kin id provided");
			
			return e;
				
			}
		
	}
	
	return null;
}

	public List<Employee> getAllEmployee() {
		if(employees.isEmpty())
			return null;
		return employees;
	}
/*public HashSet<Employee>getAllEmpy()
{
	if(empy.isEmpty())
		return null;
	return empy;	
}
*/


	
	
	public void modifyEmployee(Map empModifiedDetails,Employee emp,int ch) {
	
		switch(ch)
		{
		case 1:emp.setEmpname((String) empModifiedDetails.get("empName"));
				
				break;
		case 2:emp.setMail((String) empModifiedDetails.get("email"));
				
				break;
		case 3:emp.setPhoneNo((String) empModifiedDetails.get("phoneNo"));
		        
		        break;
		case 4:emp.setAddress((String) empModifiedDetails.get("address"));

				break;
		case 5:emp.setDob((String) empModifiedDetails.get("dob"));
				
				break;
		case 6:emp.setDoj((String) empModifiedDetails.get("doj"));
				
				break;
		

		
				
		}
	}



}

