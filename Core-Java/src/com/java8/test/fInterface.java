package com.java8.test;

@FunctionalInterface
public interface fInterface {
	abstract int sub(int x, int y);
	//abstract int mul(int x, int y);
	default int mul(int x, int y) {
		return x*y;
	}
	
	@Override
	public String toString();
	
	 @Override
	 public boolean equals(Object obj);
}

