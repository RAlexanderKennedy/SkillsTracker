package model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
	
	private String id;
	private String firstName;
	private String lastName;
	private List<String> address;
	private String contactEmail;
	private String companyEmail;
	private LocalDate birthDate;
	private LocalDate hiredDate;
	private String role;
	private String businessUnit;
	private List<String> skills;
	private String assignedTo;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<String> getAddress() {
		return address;
	}
	
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public LocalDate getHiredDate() {
		return hiredDate;
	}
	
	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getBusinessUnit() {
		return businessUnit;
	}
	
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	public List<String> getSkills() {
		return skills;
	}
	
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}
	
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public Employee(String id, String firstName, String lastName, List<String> address, String contactEmail,
			String companyEmail, LocalDate birthDate, LocalDate hiredDate, String role, String businessUnit,
			List<String> skills, String assignedTo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactEmail = contactEmail;
		this.companyEmail = companyEmail;
		this.birthDate = birthDate;
		this.hiredDate = hiredDate;
		this.role = role;
		this.businessUnit = businessUnit;
		this.skills = skills;
		this.assignedTo = assignedTo;
	}
	
	
	
}
