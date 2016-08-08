package com.flp.ems.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.EmployeeDaoImplJDBC;
import com.flp.ems.dao.IemployeeDao;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public  class EmployeeServiceImpl implements IEmployeeService {
	
	IemployeeDao empDao;
	
	
	public EmployeeServiceImpl(){
		//empDao=new EmployeeDaoImplForList();
		empDao=new EmployeeDaoImplJDBC();		
	}
	//populating the empl 
	public void addEmployee(Map empDetails)
	{

		Employee employee=new Employee();
		Department department=new Department();
		Project project=new Project();
		Role role=new Role();

		employee.setEmpid((String) empDetails.get("empId"));
		employee.setKinid((String) empDetails.get("KinId"));
		
		employee.setEmpname((String) empDetails.get("empName"));
		employee.setMail((String) empDetails.get("mail"));
		employee.setPhoneNo((String)empDetails.get("phoneNo"));
		employee.setAddress((String)empDetails.get("address"));
		employee.setDob((String)empDetails.get("dob"));
		employee.setDoj((String)empDetails.get("doj"));
		/*employee.setDeptid((Integer) empDetails.get("deptId"));
		employee.setProjId((Integer) empDetails.get("projId"));
		employee.setRoleId((Integer) empDetails.get("roleId"));*/

		department.setDeptid((Integer) empDetails.get("deptId"));
		department.setDeptName((String) empDetails.get("deptName"));

		employee.setDepartment(department);

		project.setProjId((Integer) empDetails.get("projId"));
		project.setProjName((String) empDetails.get("projName"));
		project.setDepartment(department);

		employee.setProject(project);

		role.setRoleId((Integer) empDetails.get("roleId"));
		role.setRoleName((String) empDetails.get("roleName"));

		employee.setRole(role);
		//empDao.addEmployee(employee);
		
		/*try {
			empDao.addEmployee(employee,department,project,role);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*List<Employee> employees=empDao.getAllEmployee();
		if(employees==null)
		{
			empDao.addEmployee(employee);
		}
		else if(!employees.contains(employee))// checking for duplicate
		{
		    empDao.addEmployee(employee);
		}*/
		
		try {
			empDao.addEmployee(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean removeEmployee(String kinid, String empName, String mail) {
		return empDao.removeEmployee(kinid,empName,mail);
	}

	
	public Employee searchEmployee(String kinid,String empName,String mail) throws ClassNotFoundException, SQLException{
		
		 return empDao.searchEmployee(kinid,empName,mail);
	}

	public void getAllEmployee(){
		try {
			empDao.getAllEmployee();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Employee modifyEmployee(Map empModifiedDetails,Employee emp,int ch) throws ClassNotFoundException, SQLException {
		return empDao.modifyEmployee(empModifiedDetails,emp,ch);
		
	}

}
