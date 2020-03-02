package com.java8.test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import com.test.beans.*;

import com.test.beans.Employee;

public class TestStreams {

	public static void main(String[] args) throws Exception {
		//Array List example
		List<String> list = new ArrayList<>();
		list.add("ITC");
		list.add("ITC1");
		list.add("Samsung");
		list.add("Samsung corp");
		
		List<String> list1 = new ArrayList<>(list);
		
		boolean opList = list.stream().findFirst().equals("ITC");
		System.out.println(opList);
		
		list.stream().filter(
				str->str.contains("ITC")
				).forEach(s->System.out.println(s));
		
		//we can match or compare any string in stream
		boolean flag = list.stream().anyMatch(s->s.equals("ITC123"));
		System.out.println("flag is : " + flag);
		
		//find the distinct item in the stream
		list.stream().distinct().forEach(
				s->System.out.println("distinct item : " + s)
				);
		
		String ss = new ArrayList<String>().stream().findFirst().orElseGet(()->"test");
		System.out.println("find first : " +ss);
		
		boolean noneMatch = list.stream().noneMatch(s->s.equals("aaa"));
		System.out.println("noneMatch is : " + noneMatch);
		
		List<String> ll = list.stream().filter(s->s.contains("ITC")).collect(Collectors.toList());
		System.out.println("Collected List : " + ll);
		
		//String ss1 = new ArrayList<String>().stream().findAny().get();
		//System.out.println("find Any : " +ss1);
		
		//Map example:
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "ITC");
		map.put(2, "ITC1");
		map.put(3, "ITC2");
		map.put(4, "Samsung");
		map.put(5, "Selectiva");
		
		map.values().stream().filter(
				s->s.contains("ITC")
				).forEach(s-> System.out.println("map : " + s));
		
		List<Integer> list21 = new ArrayList<>();
		List<Integer> list22 = new ArrayList<>();
		List<Integer> list23 = new ArrayList<>();
		
		list21.add(1);
		list21.add(2);
		list21.add(3);
		
		list22.add(4);
		list22.add(5);
		list22.add(6);
		
		list23.add(6);
		list23.add(7);
		list23.add(8);
		list23.add(9);
		
		List<List<Integer>> listOfList = Arrays.asList(list21,list22,list23);
		Set<Integer> listOfAllIntegers = listOfList.stream().flatMap(s->s.stream()).
											collect(Collectors.toSet());
		System.out.println("listOfAllIntegers : " +listOfAllIntegers);
		
		List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );
		
		IntStream intStream =
                listOfLists.stream()
                           .flatMapToInt(childList ->
                                   childList.stream()
                                            .mapToInt(Integer::new));
		
		List<Integer> intList = new ArrayList<>();
		intList.add(2500);
		intList.add(1345);
		intList.add(2000);
		intList.add(2500);
		intList.add(2000);
		intList.add(1345);
		
		Set<Integer> l3 = intList.stream().filter(s->Collections.frequency(intList, s) > 1).
				collect(Collectors.toSet());
		System.out.println("l3 is : " +l3);
		
		int nn = intList.stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).findFirst().get();
		System.out.println("number is : " +nn);
		
		Employee e1 = new Employee(1,"Satish",2050);
		Employee e2 = new Employee(2,"Mahesh",1500);
		Employee e3 = new Employee(3,"Ramesh",5001);
		Employee e4 = new Employee(4,"Suresh",10000);
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		Map<Integer, List<String>> m1 =  empList.stream().collect(Collectors.groupingBy(Employee::getSalary,
				Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(m1);
		
		//find employee list whose salary is geater than 5000
		empList.stream().filter(emp->emp.getSalary() > 5000).forEach(e->System.out.println(e.getName()));
		
		
		System.out.println(empList.stream().map(Employee::getName).findFirst().orElse(null));
		
		empList.stream().map(Employee::getName).forEach(name->System.out.println("name is: " +name));
	}

	
}
