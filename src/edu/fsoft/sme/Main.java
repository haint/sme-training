package edu.fsoft.sme;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import edu.fsoft.sme.data.DataSource;
import edu.fsoft.sme.models.Student;
import edu.fsoft.sme.models.Subject;

class Main {
	
	void menu() {
		System.out.println("=========== MAIN MENU ============");
		System.out.println("\t1. Student Management");
		System.out.println("\t2. Subject Management");
		System.out.println("\t3. Assessment");
		System.out.println("\t4. Exit");
		
		System.out.println("Enter your choice: ");
		try {
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				this.subMenu("STUDENT");
				break;
			case 2:
				this.subMenu("SUBJECT");
				break;
			case 3:
				this.assessment();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				this.clear();
				System.out.println("Your choice is not correct, pls enter 1-4");
				this.menu();
			}
			
		} catch (InputMismatchException ex) {
			this.clear();
			System.out.println("Your choice is not correct, pls enter 1-4");
			this.menu();
		}
	}
	
	private void assessment() {
		Iterator<Student> students = DataSource.INSTANCE.getStudents();
		
		System.out.println("============== Student Profile ============== | ===========Subjects ============");
		System.out.print("\tStudent Id \t Student name \t      |");
		Iterator<Subject> subjects = DataSource.INSTANCE.getSubjects();
		while(subjects.hasNext()) {
			System.out.print(subjects.next().getName() + " \t ");
		}
		System.out.println();
	}
	
	private void subMenu(String sub) {
		this.clear();
		StringBuilder sb = new StringBuilder();
		sb.append(sub.charAt(0)).append(sub.substring(1).toLowerCase());
		
		System.out.println("=========== " + sb + " MENU ============");
		System.out.println("\t1. Add " + sb);
		System.out.println("\t2. Update " + sb);
		System.out.println("\t3. Delete " + sb);
		System.out.println("\t4. Search " + sb);
		System.out.println("\t5. Back");
		
		System.out.println("Enter your choice: ");
		try {
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				if ("student".equals(sub.toLowerCase())) {
					this.createStudent();
				} else if ("subject".equals(sub.toLowerCase())) {

				}
			case 5:
				this.clear();
				this.menu();
				break;
			default:
				break;
			}
		
		} catch (InputMismatchException ex) {
			this.clear();
			System.out.println("Your choice is not correct, pls enter 1-5");
			this.subMenu(sub);
		} catch (NullPointerException ex) {
			System.err.println("Sub type is not correct");
		}
	}
	
	private Student createStudent() {
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
		return null;
	}
	
	private void clear() {
		for(int i = 0; i < 25; i++) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.menu();
	}
}
