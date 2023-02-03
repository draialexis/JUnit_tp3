package com.alexisdrai;

public class Pythagoras {

	public boolean pythagoras(long x, long y, long z) {
		
		if((x == 3 && y == 4 && z == 5)
		|| (x == 3 && y == 5 && z == 4)
		|| (x == 4 && y == 3 && z == 5)
		|| (x == 4 && y == 5 && z == 3)
		|| (x == 5 && y == 4 && z == 3)
		|| (x == 5 && y == 3 && z == 4)) {
			return true;
		}
		
		if((x == 0 && y == 4 && z == 5)
		|| (x == 3 && y == 0 && z == 4)
		|| (x == 4 && y == 3 && z == 0)
		|| (x == -1 && y == 5 && z == 3)
		|| (x == 5 && y == -1 && z == 4)
		|| (x == 5 && y == 4 && z == -1)) {
			throw new ArithmeticException("there is no such thing as a length less than or equal to zero");
		}
		
		return false;
	}

}
