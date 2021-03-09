package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.EmployeeDAO;
import model.Employee;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeDAO.getEmployees();
		return employees;
	};
	
	@RequestMapping(path="/employees", method=RequestMethod.POST)
	public void addEmployee(@Valid @RequestBody Employee newEmployee) {
		employeeDAO.addEmployee(newEmployee);
	};
	
	@RequestMapping(path="/employees/{id}", method=RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable String id) {
		Employee employee = employeeDAO.getEmployeeById(id);
		return employee;
	};
	
	@RequestMapping(path="/employees/{updatedEmployee.getId()}", method=RequestMethod.PUT)
	public void updateEmployee(@Valid @RequestBody Employee updatedEmployee) {
		employeeDAO.updateEmployee(updatedEmployee);
	};
	
	@RequestMapping(path="/employees/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable String id) {
		employeeDAO.deleteEmployee(id);
	};
	
	
}
