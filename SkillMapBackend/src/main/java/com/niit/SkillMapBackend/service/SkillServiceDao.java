package com.niit.SkillMapBackend.service;


import java.util.List;

import com.niit.SkillMapBackend.model.Skills;

public interface SkillServiceDao {
	public Boolean addSkillsService(Skills skills);
	public Boolean updateSkillsService(Skills skills);
    public List retriveSkillService();
}
