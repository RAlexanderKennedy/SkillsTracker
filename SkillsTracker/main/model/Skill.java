package model;

public class Skill {

	private String skillId;
	private Field field;
	private int experience;
	private String summary;
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public Skill(String skillId, Field field, int experience, String summary) {
		super();
		this.skillId = skillId;
		this.field = field;
		this.experience = experience;
		this.summary = summary;
	}
	
	
	
}
