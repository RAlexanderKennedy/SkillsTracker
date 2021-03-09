package dao;

import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import model.Address;
import model.Employee;

@Component
public class EmployeeSqlDAO implements EmployeeDAO {

	private JdbcTemplate template;
	
	public EmployeeSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "Select * from employee join address on employee.id = address.id";
		SqlRowSet rs = template.queryForRowSet(sql);
		
		while (rs.next()) {
			Employee employee = new Employee();
			
			employee.getAddress().setStreet(rs.getString("street"));
			
			if(rs.getString("suite") != null) {
			employee.getAddress().setSuite(rs.getString("suite"));;
			}
			
			employee.getAddress().setCity(rs.getString("city"));
			employee.getAddress().setRegion(rs.getString("region"));
			employee.getAddress().setPostal(rs.getString("postal"));
			employee.getAddress().setCountry(rs.getString("country"));
			
			if(rs.getString("assignedto") != null) {
			employee.setAssignedTo(rs.getString("assignedTo"));
			}
			
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			
			if(rs.getString("contactemail") != null) {
				employee.setContactEmail(rs.getString("contactemail"));
			}
			
			if(rs.getString("companyemail") != null) {
				employee.setCompanyEmail(rs.getString("companyemail"));
			}
			
			if(rs.getDate("birthdate") != null) {
				employee.setBirthDate(rs.getDate("birthdate").toLocalDate());
			}
			
			if(rs.getDate("hireddate") != null) {
				employee.setHiredDate(rs.getDate("hireddate").toLocalDate());
			}
			
			if(rs.getString("role") != null) {
				employee.setRole(rs.getString("role"));
			}
			
			if(rs.getString("businessunit") !=null) {
				employee.setBusinessUnit(rs.getString("businessunit"));
			}
			
			employees.add(employee);
		}
		return employees;
	}

	public void addEmployee(Employee newEmployee) {
		String id = newEmployee.getId();
		String firstName = newEmployee.getFirstName();
		String lastName = newEmployee.getLastName();
		String contactEmail = newEmployee.getContactEmail();
		String companyEmail = newEmployee.getCompanyEmail();
		Date birthDate = (Date) Date.from(newEmployee.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date hiredDate = (Date) Date.from(newEmployee.getHiredDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		String role = newEmployee.getRole();
		String businessUnit = newEmployee.getBusinessUnit();
		String assignedTo = newEmployee.getAssignedTo();
		Address address = newEmployee.getAddress();
		String street = address.getStreet();
		String suite = address.getSuite();
		String city = address.getCity();
		String region = address.getRegion();
		String postal = address.getPostal();
		String country = address.getCountry();
		
		String sql = "insert into employee (id, firstname, lastname, contactemail, companyemail, birthdate, hireddate, role, businessunit, assignedto) values (?,?,?,?,?,?,?,?,?,?)";
		
		template.update(sql, id, firstName, lastName, contactEmail, companyEmail, birthDate, hiredDate, role, businessUnit, assignedTo);
		
		String addressSql = "insert into address (id, street, suite, city, region, postal, country) values (?,?,?,?,?,?,?)";
		
		template.update(addressSql, id, street, suite, city, region, postal, country);
	}

	public Employee getEmployeeById(String id) {
		
		String sql = "Select * from employee join address on employee.id = address.id where employee.id = ?";
		SqlRowSet rs = template.queryForRowSet(sql, id);
		
		while (rs.next()) {
			Employee employee = new Employee();
			
			employee.getAddress().setStreet(rs.getString("street"));
			
			if(rs.getString("suite") != null) {
			employee.getAddress().setSuite(rs.getString("suite"));;
			}
			
			employee.getAddress().setCity(rs.getString("city"));
			employee.getAddress().setRegion(rs.getString("region"));
			employee.getAddress().setPostal(rs.getString("postal"));
			employee.getAddress().setCountry(rs.getString("country"));
			
			if(rs.getString("assignedto") != null) {
			employee.setAssignedTo(rs.getString("assignedTo"));
			}
			
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			
			if(rs.getString("contactemail") != null) {
				employee.setContactEmail(rs.getString("contactemail"));
			}
			
			if(rs.getString("companyemail") != null) {
				employee.setCompanyEmail(rs.getString("companyemail"));
			}
			
			if(rs.getDate("birthdate") != null) {
				employee.setBirthDate(rs.getDate("birthdate").toLocalDate());
			}
			
			if(rs.getDate("hireddate") != null) {
				employee.setHiredDate(rs.getDate("hireddate").toLocalDate());
			}
			
			if(rs.getString("role") != null) {
				employee.setRole(rs.getString("role"));
			}
			
			if(rs.getString("businessunit") !=null) {
				employee.setBusinessUnit(rs.getString("businessunit"));
			}
			
			return employee;
		}
		
		return null;
	}

	public void updateEmployee(Employee updatedEmployee) {
		String sql = "update employee set firstname = ?, lastname = ?, contactemail = ?, companyemail = ?, birthdate = ?, hireddate = ?, role = ?, businessunit = ?, assignedto = ? where id = ?";
		Date birthDate = (Date) Date.from(updatedEmployee.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date hiredDate = (Date) Date.from(updatedEmployee.getHiredDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		template.update(sql, updatedEmployee.getFirstName(), updatedEmployee.getLastName(), updatedEmployee.getContactEmail(), updatedEmployee.getCompanyEmail(), birthDate, hiredDate, updatedEmployee.getRole(), updatedEmployee.getBusinessUnit(), updatedEmployee.getAssignedTo(), updatedEmployee.getId());
		
		Address address = updatedEmployee.getAddress();
		String street = address.getStreet();
		String suite = address.getSuite();
		String city = address.getCity();
		String region = address.getRegion();
		String postal = address.getPostal();
		String country = address.getCountry();
		
		String addressSql = "update address set street = ?, suite = ?, city = ?, region = ?, postal = ?, country = ? where id = ?";
		template.update(addressSql, street, suite, city, region, postal, country, updatedEmployee.getId());
	}

	public void deleteEmployee(String id) {
		String sql = "delete from employee where id = ?";
		template.update(sql, id);

	}

}
