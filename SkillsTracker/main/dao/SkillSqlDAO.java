package dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import model.Field;
import model.Skill;

@Component
public class SkillSqlDAO implements SkillDAO {
	
	private JdbcTemplate template;
	
	public SkillSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	public List<Skill> getEmployeeSkills(String employeeId) {
		
		List<Skill> skills = new ArrayList<Skill>();
		
		String sql = "Select * from skill where id = ?";
		
		SqlRowSet rs = template.queryForRowSet(sql, employeeId);
		
		while (rs.next()) {
			Skill skill = new Skill();
			Field field = new Field();
			field.setName(rs.getString("field"));
			field.setSkillFieldId(rs.getString("skill_field_id"));
			field.setType(rs.getString("field_type"));
			skill.setField(field);
			skill.setSkillId(rs.getString("skill_id"));
			skill.setExperience(rs.getInt("experience"));
			
			if(rs.getString("summary") != null) {
				skill.setSummary(rs.getString("summary"));
			}
			
			skills.add(skill);
		}
		
		return skills;
	}

	public void addSkillToEmployee(Skill newSkill, String employeeId) {
		
		String skillId = newSkill.getSkillId();
		Field field = newSkill.getField();
		String skillFieldId = field.getSkillFieldId();
		String fieldName = field.getName();
		String fieldType = field.getType();
		int experience = newSkill.getExperience();
		String summary = newSkill.getSummary();
		
		String sql = "insert into skill (id, skill_id, skill_field_id, field, field_type, experience, summary) values (?,?,?,?,?,?,?)";
		
		template.update(sql, employeeId, skillId, skillFieldId, fieldName, fieldType, experience, summary);
		

	}

	public Skill findSkill(String skillId, String employeeId) {
		String sql = "Select * from skill where id = ? and skill_id = ?";
		
		SqlRowSet rs = template.queryForRowSet(sql, employeeId, skillId);
		
		while (rs.next()) {
			Skill skill = new Skill();
			Field field = new Field();
			field.setName(rs.getString("field"));
			field.setSkillFieldId(rs.getString("skill_field_id"));
			field.setType(rs.getString("field_type"));
			skill.setField(field);
			skill.setSkillId(rs.getString("skill_id"));
			skill.setExperience(rs.getInt("experience"));
			
			if(rs.getString("summary") != null) {
				skill.setSummary(rs.getString("summary"));
			}

			
			return skill;
		}
		return null;
	}

	public void editEmployeeSkill(Skill updatedSkill, String employeeId) {
		
		String sql = "update skill set skill_field_id = ?, field = ?, field_type = ?, experience = ?, summary = ? where id = ? and skill_id = ?";
		
		String skillId = updatedSkill.getSkillId();
		Field field = updatedSkill.getField();
		String skillFieldId = field.getSkillFieldId();
		String fieldName = field.getName();
		String fieldType = field.getType();
		int experience = updatedSkill.getExperience();
		String summary = updatedSkill.getSummary();
		
		template.update(sql, skillFieldId, fieldName, fieldType, experience, summary, employeeId, skillId);

	}

	public void deleteEmployeeSkill(String skillId, String employeeId) {
		
		String sql = "delete from skill where skill_id = ? and id = ?";
		template.update(sql, skillId, employeeId);

	}

}
