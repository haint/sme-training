package edu.fsoft.sme.models;

public class Subject implements Edu {
	
	private int id;
	
	private String name;
	
	private String desc;

	public Subject(int id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	@Override
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String desc) {
		this.desc = desc;
	}
	
	public String getDescription() {
		return desc;
	}
}
