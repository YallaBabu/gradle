package com.flp.ems.view;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;
import com.flp.ems.util.Validate;

public class UserInteraction {
	//creation of hashmap for storing details
	Map<String, Object> empDetails=new HashMap<String, Object>();
	Validate val=new Validate();
	int ch;
	Scanner sc=new Scanner(System.in);
	//creating "has a" relation between the layers 
	IEmployeeService empService;
    
	public UserInteraction()
    {
		 empService=new EmployeeServiceImpl();
	}
	
	public void addEmployee(){
		
	
		String kinId;
		System.out.println("Enter Kinid: ");
		empDetails.put("KinId",kinId=sc.nextLine());
		
		
		
//Name validation
		boolean valid;
		String name;
		while(true)
		{
			System.out.println("Enter empName: ");
		  name=sc.nextLine();
		     valid=val.isNameValid(name);
		    
		    if(valid){
		    	
		    	System.out.println("Validated");
		    	empDetails.put("empName",name);
		    	break;
   			    }
		    else{
		    	System.out.println("Invalid");
		    }
		    
			}
		
		String Str = new String(name);
		String s=Str.substring(0,2)+kinId;
		System.out.println("generated empId: "+s);
		empDetails.put("empId", s);
		
	   //mail validation    
		while(true){
			System.out.println("Enter mail: ");
		    String mail=sc.nextLine();
		     valid=val.isEmailValid(mail);
		    
		    if(valid)
		    {		    	
		    	System.out.println("Validated");
		    	empDetails.put("mail",mail);
		    		break;
		    }
		    else
		     {
		    	System.out.println("Invalid");
		     }
		    
			}

		
		
				
      //phone no validation
		while(true)
		{
		    	System.out.println("Enter phone");
		        String phone=sc.nextLine();
		        valid=val.isPhoneNumberValid(phone);
		    
		    if(valid){
		    	
		    	System.out.println("Validated");
		    	empDetails.put("phoneNo",phone);
                break;
		    	
		    }
		    else{
		    	System.out.println("Invalid");
		    }
		    
			}

		
		
		
		
		System.out.println("enter address: ");
		empDetails.put("address", sc.nextLine());
		
	
		//Dob and Doj 	
		while(true){
		   System.out.println("Enter dob: ");
		   String dob=sc.nextLine();
		   valid=val.validate(dob);
	    
	    if(valid){
	    	
	    	System.out.println("Validated");
	    	empDetails.put("dob",dob );
            break;
	    	
	    }
	    else{
	    	System.out.println("Invalid");
	    }
	    
		}
		
		while(true){
			System.out.print("Enter employee DOJ");
			String doj=sc.nextLine();
			valid=val.validate(doj);
				    
		    if(valid)
		    {
		    System.out.println("Validated");
		    empDetails.put("doj", doj);
		    	break;
		    }
		    else
		    {
		    System.out.println("Invalid");
		    }
			

		}
	  	
	 
		System.out.println("1.Financial 2.Non-Financial 3.support 4.Include new Department");
        System.out.println("enter Department Id");
		empDetails.put("deptId",ch=Integer.parseInt( sc.nextLine()));
		switch(ch)
		{
		case 1:empDetails.put("deptName","Financial" );
		       break;
		case 2:empDetails.put("deptName","Non-Financial");
		       break;
		case 3:empDetails.put("deptName","Support" );       
		       break;
		case 4:empDetails.put("deptName", sc.nextLine());
		       break;
				
		}		
		
		
		System.out.println("1.HSBC 2.AMAZON 3.MORGAN STANDLY");
		System.out.println("enter Project Id");
		empDetails.put("projId",  ch=Integer.parseInt( sc.nextLine()));
		switch(ch)
		{
		case 1:empDetails.put("projName","HSBC " );
		       break;
		case 2:empDetails.put("projName","AMAZON");
		       break;
		case 3:empDetails.put("projName","MORGAN STANDLYt" );       
		       break;
		/*case 4:empDetails.put("projName", sc.nextLine());
		       break;*/
		}
		/*System.out.println("enter Project name");
		empDetails.put("projName", sc.nextLine());
*/
		
		System.out.println("1.Manager 2.Sr.Consultant 3.Consultant");
		System.out.println("enter Role Id");
		empDetails.put("roleId", ch=Integer.parseInt( sc.nextLine()));
		switch(ch)
		{
		case 1:empDetails.put("roleName","Manager" );
		       break;
		case 2:empDetails.put("roleName","Sr.Consultant");
		       break;
		case 3:empDetails.put("roleName","Consultant" );       
		       break;
		/*case 4:empDetails.put("roleName", sc.nextLine());
		       break;*/
		}
		/*System.out.println("enter Role name");
		empDetails.put("roleName", sc.nextLine());
*/
		empService.addEmployee(empDetails);
	
		
      
	}
   

	public boolean removeEmployee()
	{
		
		String kinid;
		String empName,mail;
		while(true){
			System.out.println("1.Remove by kinId");
			System.out.println("2.Remove by name");
			System.out.println("3.Remove by mail");
			System.out.println("Enter ur choice:"); 	
			int c=Integer.parseInt(sc.nextLine());
			  
		switch(c){
		case 1:System.out.println("enter the kinid"); 
	    	   kinid=sc.nextLine();
	    	   return empService.removeEmployee(kinid,"*","*");
	    case 2:System.out.println("enter the name"); 
               empName=sc.nextLine();
               return empService.removeEmployee("*",empName,"*"); 
        case 3:System.out.println("enter the mail"); 
			   mail=sc.nextLine();
			   return empService.removeEmployee("*","*",mail);
    
			   default:System.out.println("invalid choice");
		}
		
	}

		
		
	}
	
    public Employee searchEmployee() throws ClassNotFoundException, SQLException
	{
	String kinid;
	String empName,mail;
		while(true){
		System.out.println("1.Search by kinId");
		System.out.println("2.Search by name");
		System.out.println("3.Search by mail");
		System.out.println("4.Search by id and name");
		System.out.println("5.Search by id and mail");
		System.out.println("6.Search by mail and name");
		System.out.println("7.Search by id and name");
		System.out.println("8.Search by id,name,mail");
		System.out.println("Enter ur choice:"); 	
		int c=Integer.parseInt(sc.nextLine());
		if(c==10){
			break;
		}
		switch(c){
			case 1:System.out.println("enter the kinid"); 
		    	   kinid=sc.nextLine();
		    	   return empService.searchEmployee(kinid,"*","*");
		    case 2:System.out.println("enter the name"); 
                   empName=sc.nextLine();
                   return empService.searchEmployee("*",empName,"*"); 
	        case 3:System.out.println("enter the mail"); 
				   mail=sc.nextLine();
				   return empService.searchEmployee("*","*",mail);
	        case 4:System.out.println("enter the id and name");
				   kinid=sc.nextLine();	
				   empName=sc.nextLine();
			       return empService.searchEmployee(kinid,empName,"*");
	        case 5:System.out.println("enter the id and mail"); 
			       kinid=sc.nextLine();	
			       mail=sc.nextLine();
	               return empService.searchEmployee(kinid,"*",mail);
            case 6:System.out.println("enter the mail and name"); 
			       mail=sc.nextLine();
			       empName=sc.nextLine();
			       return empService.searchEmployee("*",empName,mail);
	        case 7:System.out.println("enter the id and name"); 
			       kinid=sc.nextLine();	
			       empName=sc.nextLine();
	               return empService.searchEmployee(kinid,empName,"*");
            case 8:System.out.println("enter the id,name,mail"); 
	               kinid=sc.nextLine();	
			       empName=sc.nextLine();
			       mail=sc.nextLine();
			       return empService.searchEmployee(kinid,empName,mail);
			       default :System.out.println("wrong choice...");
   }
		}
	
		return null;
	}
	
	public void getAllEmployee(){
		empService.getAllEmployee();
	}
	
    public Employee modifyEmployee() throws ClassNotFoundException, SQLException
	{   
    	Employee emp=null;
    	String Kinid,empName,mail; 	
    	System.out.println("search to modify");
	    
	    while(true){
	    System.out.println("1.search by Name");	
	    System.out.println("2.search by mail");
	    System.out.println("3.search by Kinid");
	    int c=Integer.parseInt(sc.nextLine());
		if(c==4){
			break;
		}
		switch(c){
		case 1:System.out.println("1.Enter name to be search: ");	
	           empName=sc.nextLine();
	           emp=empService.searchEmployee("*", empName,"*" );
	           break;
		case 2:System.out.println("2.Enter mail to be search: ");	
  			   mail=sc.nextLine();
    	       emp=empService.searchEmployee("*", "*", mail);
    	       break;
		case 3:System.out.println("3.Enter kinid to be search: ");	
			   Kinid=sc.nextLine();
		       emp=empService.searchEmployee(Kinid,"*", "*");
		       break;
		}
	
	  if(emp!=null)
		{ 
			while(true)
			{ 
				Map<String,Object> empModifiedDetails=new HashMap<String,Object>();
					System.out.println("Modify Employee by:");
					System.out.println("1.Name");
					System.out.println("2.Email");
					System.out.println("3.phoneNo");
					System.out.println("4.Address");
					System.out.println("5.Dob");
					System.out.println("6.Doj");
					
					System.out.println("Enter ur choice: "); 	
					int ch=Integer.parseInt(sc.nextLine());
					if(ch==7)
					{
						break;
					}
					switch(ch)
					{
						case 1:
							System.out.println("Enter The name: ");
							empModifiedDetails.put("empName", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
							
						case 2:
							System.out.println("Enter The email: ");
							empModifiedDetails.put("mail", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
							
						case 3:
							System.out.println("Enter The phone: ");
							empModifiedDetails.put("phoneNo", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
								
						case 4:
							System.out.println("Enter The Address: ");
							empModifiedDetails.put("address", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
							
						case 5:
							System.out.println("Enter The Dob: ");
							empModifiedDetails.put("dob", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
							
						case 6:
							System.out.println("Enter The Doj: ");
							empModifiedDetails.put("dojs", sc.nextLine());
							return empService.modifyEmployee(empModifiedDetails,emp,ch);
							
					   		
					}
			}
			
		}
		
		
		
	
			   
   }
		return null;
	    
	}
}



