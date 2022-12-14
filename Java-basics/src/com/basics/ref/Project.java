package com.basics.ref;

import java.time.LocalDate;
import java.util.Iterator;

public class Project {

	public static void projectProgress() {
		System.out.println("project is making progress");
		LocalDate date= LocalDate.now();
		System.out.println("Date " +date.toString());
	}
	
	public static void threadTask() {
		for (int i = 1; i <=10; i++) {
			System.out.println(i*2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void oddNum() {
		for (int i = 1; i <=100; i++) {
			if(i%2!=0)
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
