package edu.fsoft.sme.data;

import java.util.Scanner;

import edu.fsoft.sme.models.Subject;

public class SubjectController {

	public static SubjectController INSTANCE = new SubjectController();
	
	private SubjectController() {
		
	}
	
	public void createSubject() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter subject name:");
		String name = scanner.next();

		System.out.println("Enter subject desc:");
		String desc = scanner.next();

		Subject subject = new Subject(DataSource.INSTANCE.getSubjectId(), name, desc);

		DataSource.INSTANCE.add(subject);
	}
}
