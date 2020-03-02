package com.java8.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FunctionalInterface
interface functionalInterface {
	//void samplelamda(int x);
	abstract int sum(int x, int y);
	default int sub(int x, int y) {
		return 1;
	}
}
public class TestLambda {

	public static void main(String[] args) {
		/*functionalInterface obj = (int x)-> System.out.println("X is : " + x);
		obj.samplelamda(20);*/
		
		functionalInterface obj = (x,y)-> {
			return x+y;
		};
		int z = obj.sum(10, 20);
		System.out.println("Z is "+ z);
		
		// thread example
		new Thread(()->System.out.println("My Runnable")
				).start();
		
		//1 iterating list
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("item2");
		
		list.forEach(
				item->System.out.println("item is " + item)
				);
		
		//hash map example
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Item1");
		map.put(2, "Item2");
		
		map.forEach(
				(key,value)-> System.out.println("Key is " + key + " value is " +value)
				);
		
		fInterface obj1 = (x,y)-> {
			return x-y;
		};
		
		System.out.println("The sub is : " + obj1.sub(20,10));
		System.out.println("The multi is : " + obj1.mul(20,10));
	}
}
