package com.basics.functions;

public class BasicFunction {

	public static void main(String[] args) {
		System.out.println("Add " +add(10,20));
		System.out.println("Sub " +sub(10,20));
		System.out.println("maltiply " +mal(10,20));
		System.out.println("divide " +div(10,20));
		System.out.println("square " +sq(10));
		System.out.println("cube " +cube(10));
	}

	  static Integer cube(int i) {
		return i*i*i;
	}

	  static Integer sq(int i) {
		
		return i*i;
	}

	 static Integer div(int i, int j) {
		return i/j;
	}

	 static Integer mal(int i, int j) {
		return i*j;
	}

	 static Integer sub(int i, int j) {
		return i-j;
	}

	static Integer add(int i, int j) {
		return i+j;
	}
}
