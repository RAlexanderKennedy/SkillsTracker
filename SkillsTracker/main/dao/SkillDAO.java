package dao;

import java.util.List;

import model.Skill;

public interface SkillDAO {

	public List<Skill> getEmployeeSkills(String employeeId);
	
	public void addSkillToEmployee(Skill newSkill, String employeeId);
	
	public Skill findSkill(String skillId, String employeeId);
	
	public void editEmployeeSkill(Skill updatedSkill, String employeeId);
	
	public void deleteEmployeeSkill(String skillId, String employeeId);
	
}
