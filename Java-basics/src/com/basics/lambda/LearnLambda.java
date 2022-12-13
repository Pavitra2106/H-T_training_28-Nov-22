package com.basics.lambda;

public class LearnLambda {

	public static void main(String[] args) {
		System.out.println("heloo");
		LearnLambda learn1 = new LearnLambda();
		MathOperation add = (Integer num1, Integer num2) -> num1 + num2;
		MathOperation sub = (Integer num1, Integer num2) -> num1 - num2;
		MathOperation div = (Integer num1, Integer num2) -> num1 / num2;
		MathOperation mul = (Integer num1, Integer num2) -> num1 * num2;
		
		System.out.println("ADDING ="+ learn1.opration(100,50,add));
		System.out.println("Subtract ="+ learn1.opration(100,50,sub));
		System.out.println("Division ="+ learn1.opration(100,50,div));
		System.out.println("multiplication ="+ learn1.opration(100,50,mul));
		
	}

	private Integer opration(Integer i, Integer j, MathOperation mathOperation) {
		// TODO Auto-generated method stub
		return mathOperation.operation(i, j);
	}

}
