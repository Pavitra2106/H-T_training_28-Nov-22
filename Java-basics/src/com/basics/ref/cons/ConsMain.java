package com.basics.ref.cons;

public class ConsMain {

	public static void main(String[] args) {

		System.out.println("We are study cont ref");
		
		IStudent iStudent = () ->{
			return new Student();
		};
		Student student =iStudent.getStudent();
		student.diplay();
	}
}
