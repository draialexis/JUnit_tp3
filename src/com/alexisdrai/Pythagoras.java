package com.alexisdrai;

public class Pythagoras {

	public boolean pythagoras(long x, long y, long z) {
		if(x <= 0 || y <= 0 || z <= 0) {
			throw new ArithmeticException("there is no such thing as a length less than or equal to zero");
		}
		
		long hyp = Math.max(x,  Math.max(y, z));
		if (hyp == x) {
			return (y * y) + (z * z) == (x * x);
		} 
		if (hyp == y) {
			return (x * x) + (z * z) == (y * y);
		} 
		return (x * x) + (y * y) == (z * z);
	}
}
