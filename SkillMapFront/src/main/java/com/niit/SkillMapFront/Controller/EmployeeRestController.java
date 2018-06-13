package com.niit.SkillMapFront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeServiceDao;

@RestController
@RequestMapping("/api/rest")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeRestController {
	@Autowired
	EmployeeServiceDao employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> listOfEmployee(){
		List<Employee> employeelist=employeeService.getAllEmployee();
		if(employeelist.isEmpty())
			return new ResponseEntity<List<Employee>>(employeelist,HttpStatus.EXPECTATION_FAILED);
		else
			return new ResponseEntity<List<Employee>>(employeelist,HttpStatus.OK); 
	}
	@GetMapping("/{emploeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emploeeId") int emploeeId){
		Employee employee=employeeService.getEmployeeByid(emploeeId);
		if(employee!=null)
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(employee,HttpStatus.CONFLICT);
	}
	@DeleteMapping("/{emploeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("emploeeId") int emploeeId)
	{
		if(employeeService.getEmployeeByid(emploeeId)!=null) {
			employeeService.deleteEmployee(emploeeId);
			return new ResponseEntity<Employee>(HttpStatus.OK);
	    }
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		if (employeeService.addEmployeeService(employee))
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
	}
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		//if(employeeService.getEmployeeByid(emploeeId)!=null) {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(HttpStatus.OK);
	    //}
		/*else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED); 
	}*/
	}
	

}
	
	
	
	