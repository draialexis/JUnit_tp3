package com.alexisdrai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PGCDTests {
    private PGCD pgcd;
    private static Random rdm;

    @BeforeAll
    static void initAll() {
        rdm = new Random();
    }

    @BeforeEach
    void initEach() {
        pgcd = new PGCD();
    }

    // --------------
    // add
    // --------------

    @Test
    void pgcdBasic() {
        // Arrange

        int a = 9;
        int b = 6;
        int expected = 3;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdBasicNeg() {
        // Arrange

        int a = -9;
        int b = 3;
        int expected = 3;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdOneLeft() {
        // Arrange

        int a = 1;
        int b = 23;
        int expected = 1;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdOneRight() {
        // Arrange

        int a = -42;
        int b = 1;
        int expected = 1;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdZeroLeft() {
        // Arrange

        int a = 0;
        int b = -7;
        int expected = 7;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdZeroRight() {
        // Arrange

        int a = 8;
        int b = 0;
        int expected = 8;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdZeroZero() {
        // Arrange

        int a = 0;
        int b = 0;
        int expected = 0;

        // Act

        int actual = pgcd.pgcd(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void pgcdRdm() {

        for(int i = 0 ; i <1000; i++) {
            // Arrange

            int rdmA = rdm.nextInt();
            int rdmB = rdm.nextInt();

            int expected;

            if(rdmA == rdmB) {
                expected = rdmA;
            } else if(rdmA % rdmB == 0) {
                expected = rdmB;
            } else if(rdmB % rdmA == 0) {
                expected = rdmA;
            } else {
                expected = pgcd.pgcd(rdmA, rdmB);
                assertEquals(0, rdmA % expected);
                assertEquals(0, rdmB % expected);
            }

            // Act

            long actual = pgcd.pgcd(rdmA, rdmB);

            // Assert

            assertEquals(expected, actual);
        }
    }

    @Test
    void pgcdRdmWithZero() {

        for(int i = 0 ; i <1000; i++) {
            // Arrange

            int rdmA, rdmB, expected;

            if (i % 2 == 0) {
                rdmA = rdm.nextInt();
                expected = Math.abs(rdmA);
                rdmB = 0;
            } else {
                rdmB = rdm.nextInt();
                expected = Math.abs(rdmB);
                rdmA = 0;
            }

            // Act

            long actual = pgcd.pgcd(rdmA, rdmB);

            // Assert

            assertEquals(expected, actual);
        }
    }
}
