package com.alexisdrai;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * fib(0) = 0
 * fib(1) = 1
 * fib(n) = fib(n_-1) - fib(n_-2)
 */

public class FibonacciTests {

    private Fibonacci fibonacci;

    @BeforeEach
    void initEach() {
        fibonacci = new Fibonacci();
    }

    private static Random rdm;

    @BeforeAll
    static void initAll() {
        rdm = new Random();
    }

    @Test
    void canBeCted() {
        assertInstanceOf(Fibonacci.class, new Fibonacci());
    }

    @Test
    void fibZeroReturnsZero() {
        // Arrange
        int expected = 0;

        // Act
        int actual = fibonacci.fib(0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void fibOneReturnsOne() {
        // Arrange
        int expected = 1;

        // Act
        int actual = fibonacci.fib(1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void fibMinusOneThrows() {
        // Arrange

        // Act
        int n = -1;

        // Assert
        Exception exc = assertThrows(ArithmeticException.class, () -> fibonacci.fib(n));
        assertEquals(exc.getMessage(), "Fibonacci's sequence begins at n_0");
    }

    @Test
    void fibTwoReturnsOne() {
        // Arrange
        int expected = 1;

        // Act
        int actual = fibonacci.fib(2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void fibEightReturnsTwentyOne() {
        // Arrange
        int expected = 21;

        // Act
        int actual = fibonacci.fib(8);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void fibFortyOneReturnsClosestToMaxInt() {
        // Arrange
        int expected = 165_580_141;

        // Act
        int actual = fibonacci.fib(41);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void fibOverFortyOneThrows() {
        // Arrange

        // Act
        int n = 42;

        // Assert
        Exception exc = assertThrows(IllegalArgumentException.class, () -> fibonacci.fib(n));
        assertEquals(exc.getMessage(), "fib(n>41) would exceed Integer.MAX_VALUE");
    }

    @Test
    void fibNReturnsNMinOnePlusNMinTwo() {
        for (int i = 0; i < 100; i++) {
            // Arrange
            int n = rdm.nextInt(40) + 2;
            // before fib(2), the formula is different,
            // and after fib(41), we're out of INT territory

            int expected = fibonacci.fib(n - 1) + fibonacci.fib(n - 2);

            // Act
            int actual = fibonacci.fib(n);

            // Assert
            assertEquals(expected, actual);
        }
    }
}
