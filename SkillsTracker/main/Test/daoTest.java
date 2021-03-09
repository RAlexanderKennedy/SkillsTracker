package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import dao.EmployeeSqlDAO;
import dao.SkillSqlDAO;
import model.Address;
import model.Employee;
import model.Field;
import model.Skill;

class daoTest {
	
	private static SingleConnectionDataSource dataSource;
	private EmployeeSqlDAO employeeDAO;
	private SkillSqlDAO skillDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	
		dataSource.destroy();
		
	}

	@BeforeEach
	void setUp() throws Exception {
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		employeeDAO = new EmployeeSqlDAO(dataSource);
		skillDAO = new SkillSqlDAO(dataSource);
	
	}

	@AfterEach
	void tearDown() throws Exception {
		
		dataSource.getConnection().rollback();
	}

	@Test
	public void create_new_employee_and_read_back_name() {
		
		Employee test = new Employee();
		Address testAddress = new Address();
		testAddress.setCity("Testburg");
		testAddress.setCountry("Testland");
		testAddress.setId("1test1");
		testAddress.setPostal("TestZip");
		testAddress.setRegion("Test Valley");
		testAddress.setStreet("123 Test Street");
		testAddress.setSuite("Testing Suite");
		test.setAddress(testAddress);
		test.setAssignedTo("Testman");
		test.setBirthDate(LocalDate.of(2017, 1, 13));
		test.setBusinessUnit("Testing");
		test.setCompanyEmail("test@test.com");
		test.setContactEmail("test@test.org");
		test.setFirstName("Testy");
		test.setHiredDate(LocalDate.of(2018, 3, 23));
		test.setId("1test1");
		test.setLastName("Testerson");
		test.setRole("Tester");
		
		employeeDAO.addEmployee(test);
		
		Employee actualEmployee = employeeDAO.getEmployeeById("1test1");
		
		String actualName = actualEmployee.getFirstName();
		
		String expectedName = "Testy";
		
		assertEquals(expectedName, actualName);
		
	};
	
	@Test
	public void create_employee_and_update_name() {
		
		Employee test = new Employee();
		Address testAddress = new Address();
		testAddress.setCity("Testburg");
		testAddress.setCountry("Testland");
		testAddress.setId("1test1");
		testAddress.setPostal("TestZip");
		testAddress.setRegion("Test Valley");
		testAddress.setStreet("123 Test Street");
		testAddress.setSuite("Testing Suite");
		test.setAddress(testAddress);
		test.setAssignedTo("Testman");
		test.setBirthDate(LocalDate.of(2017, 1, 13));
		test.setBusinessUnit("Testing");
		test.setCompanyEmail("test@test.com");
		test.setContactEmail("test@test.org");
		test.setFirstName("Testy");
		test.setHiredDate(LocalDate.of(2018, 3, 23));
		test.setId("1test1");
		test.setLastName("Testerson");
		test.setRole("Tester");
		
		employeeDAO.addEmployee(test);
		
		Employee updateTest = employeeDAO.getEmployeeById("1test1");
		
		updateTest.setBusinessUnit("Advanced Testing");
		
		employeeDAO.updateEmployee(updateTest);
		
		Employee actualEmployee = employeeDAO.getEmployeeById("1test1");
		
		String actualUnit = actualEmployee.getBusinessUnit();
		
		String expectedUnit = "Advanced Testing";
		
		assertEquals(expectedUnit, actualUnit);
	};
	
	@Test
	public void add_skill_to_employee_and_return_all_skills_of_that_employee() {
		
		Employee test = new Employee();
		Address testAddress = new Address();
		testAddress.setCity("Testburg");
		testAddress.setCountry("Testland");
		testAddress.setId("1test1");
		testAddress.setPostal("TestZip");
		testAddress.setRegion("Test Valley");
		testAddress.setStreet("123 Test Street");
		testAddress.setSuite("Testing Suite");
		test.setAddress(testAddress);
		test.setAssignedTo("Testman");
		test.setBirthDate(LocalDate.of(2017, 1, 13));
		test.setBusinessUnit("Testing");
		test.setCompanyEmail("test@test.com");
		test.setContactEmail("test@test.org");
		test.setFirstName("Testy");
		test.setHiredDate(LocalDate.of(2018, 3, 23));
		test.setId("1test1");
		test.setLastName("Testerson");
		test.setRole("Tester");
		
		employeeDAO.addEmployee(test);
		
		Skill testSkill = new Skill();
		Field field = new Field();
		field.setName("Testing");
		field.setSkillFieldId("123Test");
		field.setType("Test");
		testSkill.setField(field);
		testSkill.setExperience(22);
		testSkill.setSkillId("456Test");
		testSkill.setSummary("test test test test test");
		
		skillDAO.addSkillToEmployee(testSkill, "1test1");
		
		Skill actualSkill = skillDAO.findSkill("456Test", "1test1");
		
		String expectedSummary = "test test test test test";
		
		String actualSummary = actualSkill.getSummary();
		
		assertEquals(expectedSummary, actualSummary);
	}
	

}
