package com.niit.SkillMapBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillMapBackend.Dao.SkillsDao;
import com.niit.SkillMapBackend.model.Skills;

@Repository("skillsDao")
@Transactional
public class SkillsDaoImpl implements SkillsDao{

	@Autowired
	SessionFactory sessionFactory;
	public Boolean addSkills(Skills skills) {
		try {
		sessionFactory.getCurrentSession().saveOrUpdate(skills);
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Boolean updateSkills(Skills skills) {
		
		try {
			sessionFactory.getCurrentSession().update(skills);
			return true;
			}
			catch(Exception e) {
				return false;
			}
	}

	public List getAllSkills() {
	      return sessionFactory.getCurrentSession().createQuery("from Skills",Skills.class).list();
	 }
}
