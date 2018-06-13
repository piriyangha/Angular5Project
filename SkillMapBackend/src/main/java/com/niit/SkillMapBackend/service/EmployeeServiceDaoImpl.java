package com.niit.SkillMapBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMapBackend.Dao.EmployeeDao;
import com.niit.SkillMapBackend.model.Employee;

@Service
public class EmployeeServiceDaoImpl implements EmployeeServiceDao {
@Autowired
private EmployeeDao employeeDao;

	public boolean addEmployeeService(Employee employee) {
		return employeeDao.addEmployee(employee);
		
	}
	
	public Boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	public Employee getEmployeeByid(int employeeId) {
		
		return employeeDao.getEmployeeByid(employeeId);
	}
	public List getAllEmployee() {
		
		return employeeDao.getAllEmployee();
	}
	public Boolean deleteEmployee(int employeeId) {
		
		return employeeDao.deleteEmployee(employeeId);
	}

}
