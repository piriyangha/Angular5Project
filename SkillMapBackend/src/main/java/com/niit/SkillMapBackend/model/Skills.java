package com.niit.SkillMapBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Skills {
	@Id
	private int skillId;
	@OneToOne
	private Employee employee;
	private int batch_handled;
	private int students_placed;
	private  String technology;
	private String certification;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getBatch_handled() {
		return batch_handled;
	}
	public void setBatch_handled(int batch_handled) {
		this.batch_handled = batch_handled;
	}
	public int getStudents_placed() {
		return students_placed;
	}
	public void setStudents_placed(int students_placed) {
		this.students_placed = students_placed;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	
	

}
