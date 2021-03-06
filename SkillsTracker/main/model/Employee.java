package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private String contactEmail;
	private String companyEmail;
	private LocalDate birthDate;
	private LocalDate hiredDate;
	private String role;
	private String businessUnit;
	private List<Skill> skills;
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
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
	
	public String getAssignedTo() {
		return assignedTo;
	}
	
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Employee(String id, String firstName, String lastName, Address address, String contactEmail,
			String companyEmail, LocalDate birthDate, LocalDate hiredDate, String role, String businessUnit,
			List<Skill> skills, String assignedTo) {
		super();
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

	public Employee() {
		
	}
	
	public void addSkill(Skill skill) {
		
		if(this.skills== null) {
			this.skills = new ArrayList<Skill>(1);
			skills.add(skill);
		}
		else {
		skills.add(skill);
		}
	}
	
	
	
	
}
