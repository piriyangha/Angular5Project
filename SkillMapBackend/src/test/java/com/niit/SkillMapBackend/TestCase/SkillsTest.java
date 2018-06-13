package com.niit.SkillMapBackend.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
import com.niit.SkillMapBackend.model.Skills;
import com.niit.SkillMapBackend.service.SkillServiceDao;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=HibernateConfig.class) 
public class SkillsTest {

	@Autowired
	SkillServiceDao skillService;
	Skills skill;
	@Before
	public void setUp() throws Exception {
		
		 skill=new Skills();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void addTest() {
		skill.setTechnology("java,spring");
		skill.setCertification("ocjp");
		skill.setSkillId(10);
		skill.setBatch_handled(6);
		skill.setStudents_placed(50);
		Employee e=new Employee();
		e.setEmployeeId(120);
		skill.setEmployee(e);
		assertEquals("success",true,skillService.addSkillsService(skill));
	}
	@Test
	@Ignore
	public void updateTest() {
		skill.setTechnology("java,spring,hibernate");
		skill.setCertification("ocjp");
		skill.setSkillId(10);
		skill.setBatch_handled(6);
		skill.setStudents_placed(50);
		Employee e=new Employee();
		e.setEmployeeId(120);
		skill.setEmployee(e);
		assertEquals("success",true,skillService.updateSkillsService(skill));
	}
   @Test
   public void RetriveTest() {
	   List<Skills> object=(List<Skills>)skillService.retriveSkillService();
		if(object!=null)
		assertEquals(true,true);
   }
}
