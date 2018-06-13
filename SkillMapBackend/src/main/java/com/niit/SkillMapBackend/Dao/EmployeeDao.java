package com.niit.SkillMapBackend.Dao;

import java.util.List;

import com.niit.SkillMapBackend.model.Employee;

public interface EmployeeDao {
	public Boolean addEmployee(Employee employee);
	public Boolean updateEmployee(Employee employee);
	public Employee getEmployeeByid(int employeeId);
	public List getAllEmployee();
	public Boolean deleteEmployee(int employeeId);

}
