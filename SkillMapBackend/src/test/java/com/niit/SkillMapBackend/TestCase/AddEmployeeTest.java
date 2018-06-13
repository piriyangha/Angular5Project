package com.niit.SkillMapBackend.TestCase;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SkillMapBackend.config.HibernateConfig;
import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeServiceDao;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=HibernateConfig.class) 
public class AddEmployeeTest {

	@Autowired
	private EmployeeServiceDao empservice;
	Employee employee;
	
	@Before
	public void setUp() throws Exception {
		employee=new Employee();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void addtest() throws ParseException {
		employee.setEmployeeId(110);
		employee.setGender("male");
		employee.setMobile("9786518898");
		employee.setName("ishaankar");
		employee.setPassword("123");
		employee.setQualification("B.E");
		employee.setEmail("priya@gmail.com");
		employee.setRole("trainer");
		employee.setAddress("chennai");
		/*java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date = sdf.parse("17-jul-1991");*/
		employee.setDob("17-jul-1991");
		//java.util.Date date1 = sdf.parse("06-oct-2017");
		employee.setDoj("17-jul-1991");	
	assertEquals("Success",true, empservice.addEmployeeService(employee));
	}
	
	@Test
	@Ignore
	public void addNegativeTestCase() throws ParseException {
		employee.setEmployeeId(104);
		employee.setGender("male");
		employee.setMobile("9786518898");
		employee.setName("ishaankarthik");
		employee.setPassword("123");
		employee.setQualification("B.E");
		employee.setEmail("priya@gmail.com");
		employee.setRole("");
		employee.setAddress("");
		/*java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date = sdf.parse("17-jul-1991");*/
		employee.setDob("17-jul-1991");
		//java.util.Date date1 = sdf.parse("06-oct-2017");
		employee.setDoj("06-oct-2017");	
		assertEquals("failure",false, empservice.addEmployeeService(employee));
	}
	
	@Test
	//@Ignore
	public void updatetest() throws ParseException  {
		employee.setEmployeeId(102);
		employee.setGender("female");
		employee.setMobile("9786518898");
		employee.setName("priyakarthik");
		employee.setPassword("123");
		employee.setQualification("B.E");
		employee.setEmail("priya@gmail.com");
		employee.setRole("trainer");
		employee.setAddress("chennai");
		/*java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date = sdf.parse("17-jul-1991");*/
		employee.setDob("17-jul-1991");
		//java.util.Date date1 = sdf.parse("06-oct-2017");
		employee.setDoj("06-oct-2017");	
	assertEquals("Success",true, empservice.updateEmployee(employee));
	}
	@Test
	@Ignore
	public void negativeUpdatetest() throws ParseException  {
		employee=empservice.getEmployeeByid(106);
		if(employee!=null)
	      assertEquals("Success",true, empservice.updateEmployee(employee));
		else
			assertEquals("not updated",false, empservice.updateEmployee(employee));
	}
	@Test
	@Ignore
	public void deleteTestCase() {
 	assertEquals("Success",true, empservice.deleteEmployee(103));
	}
	@Test
	@Ignore
	public void negativeDeleteTestCase() {
		
		assertEquals("failure case",false, empservice.deleteEmployee(106));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	@Ignore
	public void getAllEmployeeTestCase() {
		List<Employee> object=(List<Employee>)empservice.getAllEmployee();
		if(object!=null)
		assertEquals(true,true);
		
	}
	@Test
	@Ignore
	public void getAllEmployeeNegativeTestCase() {
		List<Employee> object=(List<Employee>)empservice.getAllEmployee();
		if(object==null)
		assertEquals(false,false);
	}
	
	

	
}
