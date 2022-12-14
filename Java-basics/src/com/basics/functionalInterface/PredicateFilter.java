package com.basics.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFilter {

	public static void main(String[] args) {
		Predicate<Integer> predicate = t -> t % 2 == 0;
		System.out.println(predicate.test(20));
         List<Integer> numList =Arrays.asList(1,2,3,4,5);
         numList.stream().filter(predicate).forEach(num ->System.out.println("Print -> " +num));
	}
}
