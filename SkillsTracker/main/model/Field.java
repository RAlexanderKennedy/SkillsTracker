package model;

public class Field {
	
	private String skillFieldId;
	private String name;
	private String type;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getSkillFieldId() {
		return skillFieldId;
	}

	public void setSkillFieldId(String skillFieldId) {
		this.skillFieldId = skillFieldId;
	}

	public Field(String skillFieldId, String name, String type) {
		super();
		this.skillFieldId = skillFieldId;
		this.name = name;
		this.type = type;
	}

	public Field() {
		
	}
	
	
	
	
}
