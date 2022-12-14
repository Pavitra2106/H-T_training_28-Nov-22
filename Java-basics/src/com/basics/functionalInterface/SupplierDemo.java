package com.basics.functionalInterface;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {

	@Override
	public String get() {
		return "Hello Supplier";

	}

	public static void main(String[] args) {
		Supplier<String> supplier=  new SupplierDemo();
		System.out.println(supplier.get());
	}
}
