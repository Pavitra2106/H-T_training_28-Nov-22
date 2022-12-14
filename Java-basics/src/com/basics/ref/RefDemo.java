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
		
		
//		Runnable runnable = Project::threadTask;
//		Thread t1 =new Thread(runnable);
//		//t1.start();
//		
		Runnable runnable1 = Project::oddNum;
		Thread t2 =new Thread(runnable1);
		t2.start();
	}
	

}
