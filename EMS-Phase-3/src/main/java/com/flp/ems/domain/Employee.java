package com.flp.ems.domain;

public class Employee {

private String kinid;
private String empid;
private  String empname;
private String mail;
private String phoneNo;
private String address;
private String dob;
private String doj;
private Department department;
private Project project;
private Role role;
public String getKinid() {
	return kinid;
}
public void setKinid(String kinid) {
	this.kinid = kinid;
}
public String getEmpid() {
	return empid;
}
public void setEmpid(String empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Override
public String toString() {
	return "Employee [kinid=" + kinid + ", empid=" + empid + ", empname=" + empname + ", mail=" + mail + ", phoneNo="
			+ phoneNo + ", address=" + address + ", dob=" + dob + ", doj=" + doj + "]";
}





}
