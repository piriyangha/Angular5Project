package com.niit.SkillMapBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillMapBackend.Dao.EmployeeDao;
import com.niit.SkillMapBackend.model.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	public Boolean addEmployee(Employee employee) {
		try {
		sessionFactory.getCurrentSession().saveOrUpdate(employee); 
		return true;
		}catch(Exception e) {
			return false;
		}
	}

	public Boolean updateEmployee(Employee employee) {
		try {
		sessionFactory.getCurrentSession().update(employee);
		return true;
		}catch(Exception e) {
		return false;
		}
	}

	public Employee getEmployeeByid(int employeeId) {
		return (Employee) sessionFactory.getCurrentSession().createQuery("from Employee where employeeId="+employeeId).uniqueResult();	
	}

	public List getAllEmployee() {
			return sessionFactory.getCurrentSession().createQuery("from Employee",Employee.class).list() ;
		}

	public Boolean deleteEmployee(int employeeId) {
		try {
		sessionFactory.getCurrentSession().delete(getEmployeeByid(employeeId)); 
		return true;
		}catch(Exception e) {
			return false;
			
		}
	}

}
