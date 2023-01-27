package com.alexisdrai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void canBeCted() {
        assertNotNull(new Fibonacci());
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

}
