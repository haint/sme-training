package edu.fsoft.sme.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.fsoft.sme.models.Edu;
import edu.fsoft.sme.models.Student;
import edu.fsoft.sme.models.Subject;

public class DataSource {

	private List<Student> students = new ArrayList<Student>();
	
	private List<Subject> subjects = new ArrayList<Subject>();
	
	private int studentCounter = 0;
	
	private int subjectCounter = 0;
	
	public static DataSource INSTANCE = new DataSource();
	
	private DataSource() {
		
	}
	
	public int getStudentId() {
		return studentCounter++;
	}
	
	public int getSubjectId() {
		return subjectCounter++;
	}
	
	/**
	 * Add an edu into list.
	 * 
	 * @param edu is children of Edu class
	 */
	public void add(Edu edu) {
		
		if (edu instanceof Student) {
			
			students.add((Student) edu);
			
		} else if (edu instanceof Subject) {
			
			subjects.add((Subject) edu);
			
		}
	}
	
	/**
	 * 
	 * @return page list of subjects
	 */
	public Iterator<Subject> getSubjects() {
		return subjects.iterator();
	}
	
	/**
	 * 
	 * @return page list of students
	 */
	public Iterator<Student> getStudents() {
		return students.iterator();
	}
}
