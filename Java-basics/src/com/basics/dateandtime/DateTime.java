package com.basics.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTime {

	public static void main(String[] args) {
   LocalDate localDate= LocalDate.now();
   System.out.println(localDate);
   
   LocalDateTime localDateTime = LocalDateTime.now();
   System.out.println(localDateTime);
   
   LocalTime localTime = LocalTime.now();
   System.out.println(localTime);
	}

}
