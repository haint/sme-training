package edu.fsoft.sme.models;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student implements Edu, Serializable {

	private int id;
	
	private String name;
	
	private String gender;
	
	private Date dateOfBirth;
	
	private Map<Subject, Float> mark;
	
	public Student(int id, String name, String gender, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.mark = new HashMap<Subject, Float>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void addMark(Subject sub, float mark) {
		this.mark.put(sub, mark);
	}
	
	public float avg() {
		
		return 0;
	}
	
	public Map<Subject, Float> getMark() {
		return Collections.unmodifiableMap(this.mark);
	}

	@Override
	public int getID() {
		return this.id;
	}
}
