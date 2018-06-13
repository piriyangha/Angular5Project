package com.niit.SkillMapBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMapBackend.Dao.SkillsDao;
import com.niit.SkillMapBackend.model.Skills;

@Service
public class SkillServiceDaoImpl implements SkillServiceDao{

	@Autowired
	SkillsDao skillDao;
	public Boolean addSkillsService(Skills skills) {
		skillDao.addSkills(skills);
		return true;
	}

	public Boolean updateSkillsService(Skills skills) {
		skillDao.updateSkills(skills);
		return true;
	}
	public List retriveSkillService() {
		return skillDao.getAllSkills();
	}

}
