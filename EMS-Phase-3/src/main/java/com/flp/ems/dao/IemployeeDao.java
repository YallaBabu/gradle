package com.flp.ems.dao;

import java.sql.SQLException;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public interface IemployeeDao {

    public void addEmployee(Employee employee)throws ClassNotFoundException, SQLException;
    public void getAllEmployee()throws ClassNotFoundException,SQLException;
  
	public Employee searchEmployee(String kinid, String empName, String mail) throws ClassNotFoundException, SQLException;

	public Employee modifyEmployee(Map empModifiedDetails, Employee emp, int ch) throws SQLException, ClassNotFoundException;
	public boolean removeEmployee(String kinid, String empName, String mail);
	//public void getAllEmployee();
	  //public HashSet<Employee>getAllEmpy();
//	public void modifyEmployee(Map empModifiedDetails, int empId, int ch);
}

