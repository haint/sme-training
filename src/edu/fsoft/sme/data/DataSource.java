package edu.fsoft.sme.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.fsoft.sme.models.Edu;
import edu.fsoft.sme.models.Student;
import edu.fsoft.sme.models.Subject;

public class DataSource {

	private Map<Integer, Student> students = new HashMap<Integer, Student>();
	
	private Map<Integer, Subject> subjects = new HashMap<Integer, Subject>();
	
	private int studentCounter = 1;
	
	private int subjectCounter = 1;
	
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
			
			Student st = (Student) edu;
			
			students.put(st.getID(), st);
			
		} else if (edu instanceof Subject) {
			
			Subject sb = (Subject) edu;
			
			subjects.put(sb.getID(), sb);
			
		}
	}
	
	/**
	 * 
	 * @return page list of subjects
	 */
	public Iterator<Subject> getSubjects() {
		return subjects.values().iterator();
	}
	
	public Subject getSubject(int subId) {
		return subjects.get(subId);
	}
	
	/**
	 * 
	 * @return page list of students
	 */
	public Iterator<Student> getStudents() {
		return students.values().iterator();
	}
	
	public Student getStudent(int studentId) {
		return students.get(studentId);
	}
	
	public void updateStudent(Student student) {
		students.put(student.getID(), student);
	}
}
