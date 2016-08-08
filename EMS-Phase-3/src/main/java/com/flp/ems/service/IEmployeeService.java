package com.flp.ems.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {
	public void addEmployee(Map empDetails);
	public void getAllEmployee();
	public Employee searchEmployee(String kinid, String empName, String mail) throws ClassNotFoundException, SQLException;
	public Employee modifyEmployee(Map<String, Object> empModifiedDetails,Employee emp, int ch) throws ClassNotFoundException, SQLException;
	public boolean removeEmployee(String kinid, String empName, String mail);
}

/*

public Employee ModifyEmployee(Map<String, Object> modify,String name,String emailid,String kinid,int ch ) {
	Employee emp=SearchEmployee(name,emailid,kinid);
	int index=employees.indexOf(emp);
	RemoveEmployee(name);
	switch(ch)
	{
	case 1:
		emp.setName((String) modify.get("Name"));
		employees.add(index,emp);
		break;
		
	case 2:
		emp.setEmail_Id((String) modify.get("Email_Id"));
		employees.add(index,emp);
		break;
		
	
	}
	return null;
	
	
	
	
}

public boolean RemoveEmployee(String name){
	// TODO Auto-generated method stub

	for(Employee e:employees)
	{
		if(e.getName().equals(name))
		{
			employees.remove(e);
			return true;
		}
	}
	//System.out.println("employee list deleted.......");
	
	return false;
}
	
}*/