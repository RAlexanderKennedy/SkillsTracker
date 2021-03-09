package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.SkillDAO;
import model.Skill;

@RestController
@CrossOrigin
public class SkillController {

	@Autowired
	SkillDAO skillDAO;
	
	@RequestMapping(path="/employees/{employeeId}/skills", method=RequestMethod.GET)
	public List<Skill> getEmployeeSkills(@PathVariable String employeeId){
		List<Skill> skills = skillDAO.getEmployeeSkills(employeeId);
		return skills;
	};
	
	@RequestMapping(path="/employees/{employeeId}/skills", method=RequestMethod.POST)
	public void addSkill(@Valid @RequestBody Skill skill, @PathVariable String employeeId) {
		skillDAO.addSkillToEmployee(skill, employeeId);
	};
	
	@RequestMapping(path="/employees/{employeeId}/skills/{skillId}", method=RequestMethod.GET)
	public Skill findSkill(@PathVariable String skillId, @PathVariable String employeeId) {
		Skill skill = skillDAO.findSkill(skillId, employeeId);
		return skill;
	};
	
	@RequestMapping(path="/employees/{employeeId}/skills/{updatedSkill.getSkillId()}", method=RequestMethod.PUT)
	public void editEmployeeSkill(@Valid @RequestBody Skill updatedSkill, @PathVariable String employeeId) {
		skillDAO.editEmployeeSkill(updatedSkill, employeeId);
	};
	
	@RequestMapping(path="/employees/{employeeId}/skills/{skillId}", method=RequestMethod.DELETE)
	public void deleteEmployeeSkill(@PathVariable String skillId, String employeeId) {
		skillDAO.deleteEmployeeSkill(skillId, employeeId);
	}
	
	
}
