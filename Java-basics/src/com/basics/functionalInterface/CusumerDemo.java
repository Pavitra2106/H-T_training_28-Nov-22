package com.basics.functionalInterface;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CusumerDemo {
	public static void main(String[] args) {
		
		Consumer<Integer> consumer=(t) -> System.out.println("print "+ t);
		consumer.accept(2000);
		
		List<Integer> numList= Arrays.asList(1,2,3,4,5);
		numList.stream().forEach(consumer);
		numList.stream().forEach(num -> System.out.println("print "+ num));
	}

}
