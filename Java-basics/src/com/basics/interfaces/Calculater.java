package com.basics.interfaces;

interface Square{
	void square();
	void add ();
	void sub();
	void mal();
	void div();
	static Integer sq (Integer x)
	{
		return x*x;
	}
	static Integer addNo (Integer x, Integer y)
	{
		return x+x;
	}
	static Integer subNo (Integer x, Integer y)
	{
		return x-x;
	}
	static Integer malNo (Integer x, Integer y)
	{
		return x*x;
	}
	static Integer divNo (Integer x, Integer y)
	{
		return x/x;
	}
}

public class Calculater {

	public static void main(String[] args) {
		Square s1= new SquareOfNo();
		s1.square();
		System.out.println(Square.sq(10));
		s1.add();
		System.out.println(Square.addNo(100,10));
		s1.sub();
		System.out.println(Square.subNo(100,50));
		s1.mal();
		System.out.println(Square.malNo(10,1));
		s1.div();
		System.out.println(Square.divNo(10,2));
		
	}
}
class SquareOfNo implements Square{

	@Override
	public void square() {
		System.out.println("Square of the number is: ");
		
	}

	@Override
	public void add() {
		System.out.println("adding of the number is: ");
		
	}

	@Override
	public void sub() {
		System.out.println("subtraction of the number is: ");
		
	}

	@Override
	public void mal() {
		System.out.println("maltiplication of the number is: ");
		
	}

	@Override
	public void div() {
		System.out.println("Division of the number is: ");
	}
	
}
