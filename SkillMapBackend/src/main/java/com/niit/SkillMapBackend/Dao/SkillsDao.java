package com.niit.SkillMapBackend.Dao;

import java.util.List;
import com.niit.SkillMapBackend.model.Skills;

public interface SkillsDao {
	public Boolean addSkills(Skills skills);
	public Boolean updateSkills(Skills skills);
	//public Skills getSkillByid(int skillId);
	public List getAllSkills();
	//public Boolean deleteSkill(int skillId);

}
