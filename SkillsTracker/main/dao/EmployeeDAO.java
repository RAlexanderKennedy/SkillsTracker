package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public void addEmployee(Employee newEmployee);
	
	public Employee getEmployeeById(String id);
	
	public void updateEmployee(Employee updatedEmployee);
	
	public void deleteEmployee(String id);
	
}
