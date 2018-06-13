package com.niit.SkillMapBackend.service;

import java.util.List;

import com.niit.SkillMapBackend.model.Employee;

public interface EmployeeServiceDao {
	public boolean addEmployeeService(Employee employee);
	public Boolean updateEmployee(Employee employee);
	public Employee getEmployeeByid(int employeeId);
	public List getAllEmployee();
    public Boolean deleteEmployee(int employeeId);

}


