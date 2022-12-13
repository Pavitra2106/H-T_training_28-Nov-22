package com.basics.interfaces;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
	Predicate<Integer> predicate = num ->(num > 20);
	System.out.print(predicate.test(21));
	}
}
