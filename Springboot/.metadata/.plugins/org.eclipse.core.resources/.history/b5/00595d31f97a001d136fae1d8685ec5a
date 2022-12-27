package com.basics.interfaces;

interface Square{
	void square();
	
	static Integer sq (Integer x)
	{
		return x*x;
	}
}

public class Calculater {

	public static void main(String[] args) {
		Square s1= new SquareOfNo();
		s1.square();
		System.out.print(Square.sq(10));
	}
}
class SquareOfNo implements Square{

	@Override
	public void square() {
		System.out.println("Square of the number is: ");
		
	}
	
}
