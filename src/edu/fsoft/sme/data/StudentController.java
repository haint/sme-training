package edu.fsoft.sme.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.fsoft.sme.models.Student;
import edu.fsoft.sme.models.Subject;

public class StudentController {

	public static StudentController INSTANCE = new StudentController();
	
	private StudentController() {
		
	}
	
	public void createStudent() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter student name:");
			String name = scanner.next();
			
			System.out.println("Enter student gender:");
			String gender = scanner.next();
			
			System.out.println("Enter student date of birth (dd/MM/yyyy)");
			String dob = scanner.next();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dateOfBirth = formatter.parse(dob);
			Student student = new Student(DataSource.INSTANCE.getStudentId(), name, gender, dateOfBirth);
			
			DataSource.INSTANCE.add(student);
				
		} catch (InputMismatchException ex) {
			
		} catch (ParseException ex) {
			System.out.println("Re-Enter student form: ");
			this.createStudent();
		}
	}
	
	public void addMark(int studentId, int subjectId, float score) {
		Student st = DataSource.INSTANCE.getStudent(studentId);
		Subject sb = DataSource.INSTANCE.getSubject(subjectId);
		
		st.addMark(sb, score);
		DataSource.INSTANCE.updateStudent(st);
	}

}
