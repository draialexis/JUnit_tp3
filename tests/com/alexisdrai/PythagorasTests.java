package com.alexisdrai;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class OperationsTests {

	private Pythagoras pyth;
	private static Random rdm;
	
	@BeforeAll
	static void initAll() {
		rdm = new Random();
	}
	
	@BeforeEach 
    void initEach() {
		pyth = new Pythagoras();
    }
	
	// --------------
	// pythagoras
	// --------------
	
	@ParameterizedTest
	@ArgumentsSource(pythBasicArgumentsProvider.class)
	void pythBasic(long x, long y, long z) {
		assertTrue(pyth.pythagoras(x, y, z));
	}
	
	@ParameterizedTest
	@ArgumentsSource(pythNegArgumentsProvider.class)
	void pythNeg(long x, long y, long z) {
		Exception exc = assertThrows(ArithmeticException.class, () -> {
			pyth.pythagoras(x, y, z);
		});
		
		assertEquals(exc.getMessage(), "there is no such thing as a negative length");
	}
	
	@ParameterizedTest
	@ArgumentsSource(pythNonRectArgumentsProvider.class)
	void pythNonRect(long x, long y, long z) {
		assertFalse(pyth.pythagoras(x, y, z));
	}
	
	//TODO add math seed
	
}
