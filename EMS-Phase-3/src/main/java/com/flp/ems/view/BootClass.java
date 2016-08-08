package com.flp.ems.view;

import java.sql.SQLException;
import java.util.*;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class BootClass {

	
		
		static UserInteraction ui=new UserInteraction();
		
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
		while(true){
	    System.out.println("Menu");
	    System.out.println("1.Add Employee 2.Modify Employee 3.Remove Employee 4.Search Employee 5.Get Employee Details");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();
		menuSelection(ch);
		     }
		}
		public static void menuSelection(int ch){
			
			Employee emp = new Employee();
			Department d=new Department();
			 Project p=new Project();
			 Role r=new Role();

			List<Employee> emps;
			
			switch(ch){
				case 1: ui.addEmployee();
						break;
			    case 2:          
				try {
					emp=ui.modifyEmployee();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

					        if(emp != null)
					        {
					       	System.out.println("Employee Modified "+emp);
                                  					        }
					         
					        else
						    System.out.println("Employee Not Found");
					        break;
			    	        
							      
				      
				case 3:ui.removeEmployee();
          				break;
				case 4:try {
					emp=ui.searchEmployee();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				        if(emp != null){
				       	System.out.println("Employee Found "+emp+
				       		 emp.getDepartment().getDeptid()+
                             emp.getDepartment().getDeptName()+
                             emp.getProject().getProjId()+
                             emp.getProject().getProjName()+
                             emp.getRole().getRoleId()+
                             emp.getRole().getRoleName());
                          }
				        else
					    System.out.println("Employee Not Found");
				        break;
				case 5:ui.getAllEmployee();
				        /*if(emps != null)
					    System.out.println("All Employees details are "+emps);
				        else
				      	System.out.println("No Employees Found");
				        break;*/
				        break;
				case 6:System.exit(0);
				
			          }
		  }
		
}
