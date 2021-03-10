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
import model.Field;
import model.Skill;

@Component
public class EmployeeSqlDAO implements EmployeeDAO {

	private JdbcTemplate template;
	
	public EmployeeSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "Select * from employee left outer join address on employee.id = address.id";
		SqlRowSet rs = template.queryForRowSet(sql);
		String skillSql = "Select * from skill where id = ?";
		
		while (rs.next()) {
			Employee employee = new Employee();
			Address address = new Address();
			
			address.setStreet(rs.getString("street"));
			address.setSuite(rs.getString("suite"));;
			address.setCity(rs.getString("city"));
			address.setRegion(rs.getString("region"));
			address.setPostal(rs.getString("postal"));
			address.setCountry(rs.getString("country"));
			address.setId(rs.getString(1));
			
			
			employee.setAddress(address);
			employee.setAssignedTo(rs.getString("assignedto"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setContactEmail(rs.getString("contactemail"));
			employee.setCompanyEmail(rs.getString("companyemail"));
			employee.setId(rs.getString(1));
			employee.setBirthDate(null);
			
			if(rs.getDate("birthdate") != null) {
				employee.setBirthDate(rs.getDate("birthdate").toLocalDate());
			}
			
			employee.setHiredDate(null);
			if(rs.getDate("hireddate") != null) {
				employee.setHiredDate(rs.getDate("hireddate").toLocalDate());
			}
			
			employee.setRole(rs.getString("role"));
			employee.setBusinessUnit(rs.getString("businessunit"));
			
			SqlRowSet skillRs = template.queryForRowSet(skillSql, employee.getId());
			
			while(skillRs.next()) {
				Skill skill = new Skill();
				Field field = new Field();
			
				skill.setExperience(skillRs.getInt("experience"));
				skill.setSkillId(skillRs.getString("skill_id"));
				skill.setSummary(skillRs.getString("summary"));
			
				field.setName(skillRs.getString("field"));
				field.setSkillFieldId(skillRs.getString("skill_field_id"));
				field.setType(skillRs.getString("field_type"));
			
				skill.setField(field);
			
				if(skill.getSkillId()!=null) {
					employee.addSkill(skill);
				}
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
		Date birthDate = Date.valueOf(newEmployee.getBirthDate());
		Date hiredDate = Date.valueOf(newEmployee.getHiredDate());
		String role = newEmployee.getRole();
		String businessUnit = newEmployee.getBusinessUnit();
		String assignedTo = newEmployee.getAssignedTo();
		
		String sql = "insert into employee (id, firstname, lastname, contactemail, companyemail, birthdate, hireddate, role, businessunit, assignedto) values (?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, id, firstName, lastName, contactEmail, companyEmail, birthDate, hiredDate, role, businessUnit, assignedTo);
		
		if(newEmployee.getAddress() != null) {
			Address address = newEmployee.getAddress();
			String street = address.getStreet();
			String suite = address.getSuite();
			String city = address.getCity();
			String region = address.getRegion();
			String postal = address.getPostal();
			String country = address.getCountry();
			String addressSql = "insert into address (id, street, suite, city, region, postal, country) values (?,?,?,?,?,?,?)";
			template.update(addressSql, id, street, suite, city, region, postal, country);
		}
		
		
		
	}

	public Employee getEmployeeById(String id) {
		
		String sql = "Select * from employee join address on employee.id = address.id left outer join skill on employee.id = skill.id where employee.id = ?";
		SqlRowSet rs = template.queryForRowSet(sql, id);
		
		while (rs.next()) {
			
			Employee employee = new Employee();
			Address address = new Address();
			Skill skill = new Skill();
			Field field = new Field();
			
			address.setStreet(rs.getString("street"));
			address.setSuite(rs.getString("suite"));;
			address.setCity(rs.getString("city"));
			address.setRegion(rs.getString("region"));
			address.setPostal(rs.getString("postal"));
			address.setCountry(rs.getString("country"));
			address.setId(rs.getString(1));
			
			skill.setExperience(rs.getInt("experience"));
			skill.setSkillId(rs.getString("skill_id"));
			skill.setSummary(rs.getString("summary"));
			
			field.setName(rs.getString("field"));
			field.setSkillFieldId(rs.getString("skill_field_id"));
			field.setType(rs.getString("field_type"));
			
			skill.setField(field);
			
			if(skill.getSkillId()!=null) {
			employee.addSkill(skill);
			}
			
			employee.setAddress(address);
			employee.setAssignedTo(rs.getString("assignedto"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setContactEmail(rs.getString("contactemail"));
			employee.setCompanyEmail(rs.getString("companyemail"));
			employee.setId(rs.getString(1));
			employee.setBirthDate(null);
			
			if(rs.getDate("birthdate") != null) {
				employee.setBirthDate(rs.getDate("birthdate").toLocalDate());
			}
			
			employee.setHiredDate(null);
			if(rs.getDate("hireddate") != null) {
				employee.setHiredDate(rs.getDate("hireddate").toLocalDate());
			}
			
			employee.setRole(rs.getString("role"));
			employee.setBusinessUnit(rs.getString("businessunit"));
			return employee;
		}
		
		return null;
	}

	public void updateEmployee(Employee updatedEmployee) {
		String sql = "update employee set firstname = ?, lastname = ?, contactemail = ?, companyemail = ?, birthdate = ?, hireddate = ?, role = ?, businessunit = ?, assignedto = ? where id = ?";
		Date birthDate = Date.valueOf(updatedEmployee.getBirthDate());
		Date hiredDate = Date.valueOf(updatedEmployee.getHiredDate());
		template.update(sql, updatedEmployee.getFirstName(), updatedEmployee.getLastName(), updatedEmployee.getContactEmail(), updatedEmployee.getCompanyEmail(), birthDate, hiredDate, updatedEmployee.getRole(), updatedEmployee.getBusinessUnit(), updatedEmployee.getAssignedTo(), updatedEmployee.getId());
		
		if(updatedEmployee.getAddress() != null) {
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
	}

	public void deleteEmployee(String id) {
		String skillSql = "delete from skill where id = ?";
		template.update(skillSql,id);
		String addressSql = "delete from address where id = ?";
		template.update(addressSql,id);
		String sql = "delete from employee where id = ?";
		template.update(sql, id);

	}

}
