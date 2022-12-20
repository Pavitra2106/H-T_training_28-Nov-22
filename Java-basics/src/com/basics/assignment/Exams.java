package com.basics.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exams {

	public static void main(String[] args) {
		List<ExamsEntity> examsEntity = new ArrayList<>();
		examsEntity.add(new ExamsEntity(1,"Pavitra","IIT",3,10000));
		examsEntity.add(new ExamsEntity(2,"Rohit","JEE",13,12000));
		examsEntity.add(new ExamsEntity(3,"Mohit","CAT",12,9000));
		examsEntity.add(new ExamsEntity(4,"Mahesh","MHCET",1,11000));
		examsEntity.add(new ExamsEntity(5,"Somesh","UPSC",4,15000));
		examsEntity.add(new ExamsEntity(6,"Amol","SSC",2,4000));
		examsEntity.add(new ExamsEntity(7,"Vivek","AIEEE",15,14000));
		examsEntity.add(new ExamsEntity(8,"Om","NEET",5,13000));
		examsEntity.add(new ExamsEntity(9,"Pandurang","XAT",6,2000));
		examsEntity.add(new ExamsEntity(10,"Ashish","CDS",11,5000));
		examsEntity.add(new ExamsEntity(11,"Astik","FCI",7,3000));
		examsEntity.add(new ExamsEntity(12,"Rahul","GATE",8,1000));
		examsEntity.add(new ExamsEntity(13,"Aditya","IES",10,6000));
		examsEntity.add(new ExamsEntity(14,"Sharad","FCI",9,7000));

        Collections.sort(examsEntity,(o1, o2) -> o1.getTotalFees() - o2.getTotalFees());

        System.out.println("\n");
        System.out.println("After sorting total fees in ascending order");

        examsEntity.forEach((s) -> System.out.println(s));
        Collections.sort(examsEntity,(o1, o2) -> o2.getTotalFees() - o1.getTotalFees());
       
        System.out.println("\n");
        System.out.println("After sorting total fees in descending order");

        examsEntity.forEach((s) -> System.out.println(s));
        Collections.sort(examsEntity,(o1, o2) -> o1.getCourseDuration() - o2.getCourseDuration());

        System.out.println("\n");
        System.out.println("After sorting course duration shortest to longest");

        examsEntity.forEach((s) -> System.out.println(s));
        Collections.sort(examsEntity, (o1, o2) -> o2.getCourseDuration() - o1.getCourseDuration());

//        System.out.println("\n");
//        System.out.println("After sorting course duration longest to shortest");
//
//        examsEntity.forEach((s) -> System.out.println(s));

	}

}
