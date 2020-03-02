package com.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.beans.Employee;


public class TestStreams1 {
	
	public void streamsTest() {
	//filter method
		List<String> list = Arrays.asList("abc","prashant","def","pradeep");
		//list.stream().filter(s->s.contains("pra")).forEach(ss-> System.out.println(ss));
		
		Employee e1 = new Employee(1,"Satish",2050);
		Employee e2 = new Employee(2,"Mahesh",1500);
		Employee e3 = new Employee(3,"Ramesh",5001);
		Employee e4 = new Employee(4,"Suresh",10000);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		Employee e11 = null;
		Optional<Employee> opp = Optional.ofNullable(e11);
		//System.out.println("e11 : " + opp.get().getName());
		//opp.ifPresent();
		opp.ifPresent(System.out::println);
		
		empList.stream().map(Employee::getName).collect(Collectors.toList())
		.forEach(s->System.out.println(s));
		
		List<Employee> list11 = null;
		Optional<List<Employee>> opt = Optional.ofNullable(list11);
		//System.out.println("is present : " + opt.isPresent());
	}
 
	public static void main(String[] args) {
		new TestStreams1().streamsTest();
	}
}
