package com.basics.ref;

public class RefDemo {

	public static void main(String[] args) {
		System.out.println("Method reference demo");
		
//		IWork iWork = ()->{
//			System.out.println("Project form IWORK");
//		};
//		iWork.doProject();
		
		IWork iWorks = Project ::projectProgress;
		iWorks.doProject();
	}
	

}
