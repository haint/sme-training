package edu.fsoft.sme;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import edu.fsoft.sme.data.DataSource;
import edu.fsoft.sme.data.StudentController;
import edu.fsoft.sme.data.SubjectController;
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
		System.out.println("============== Student Profile ============== | ===========Subjects ============");
		System.out.print("\tStudent Id \t Student name \t      |");
		
		Iterator<Subject> subjects = DataSource.INSTANCE.getSubjects();
		
		while(subjects.hasNext()) {
			System.out.print(subjects.next().getName() + " \t ");
		}
		
		System.out.println();
		
		Iterator<Student> students = DataSource.INSTANCE.getStudents();
		
		while (students.hasNext()) {
			Student st = students.next();
			Map<Subject, Float> marks = st.getMark();
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("\t");
			
			for (Float f : marks.values()) {
				stringBuilder.append(f).append("\t");
			}
			
			System.out.println(st.getID() + "\t" + st.getName() + stringBuilder.toString());
		}
		
		
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
					StudentController.INSTANCE.createStudent();
				} else if ("subject".equals(sub.toLowerCase())) {
					SubjectController.INSTANCE.createSubject();
				}
			case 2:
				if ("student".equals(sub.toLowerCase())) {
					
					System.out.println("Enter student id:");
					int stuId = scanner.nextInt();
					
					System.out.println("Enter subject id:");
					int subId = scanner.nextInt();
					
					System.out.println("Enter score:");
					float score = scanner.nextFloat();
					
					StudentController.INSTANCE.addMark(stuId, subId, score);
					
				} else if ("subject".equals(sub.toLowerCase())) {
					
				}
			case 5:
				this.clear();
				this.menu();
				break;
			default:
				this.clear();
				this.subMenu(sub);
			}
		
		} catch (InputMismatchException ex) {
			this.clear();
			System.out.println("Your choice is not correct, pls enter 1-5");
			this.subMenu(sub);
		} catch (NullPointerException ex) {
			System.err.println("Sub type is not correct");
		}
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
