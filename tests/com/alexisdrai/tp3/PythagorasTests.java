package com.alexisdrai.tp3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Random;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class PythagorasTests {

    private static Random rdm;
    private Pythagoras pyth;

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

    @Test
    void canBeCted() {
        assertInstanceOf(Pythagoras.class, new Pythagoras());
    }

    @ParameterizedTest
    @ArgumentsSource(pythBasicArgumentsProvider.class)
    void pythBasic(long x, long y, long z) {
        assertTrue(pyth.pythagoras(x, y, z));
    }

    @ParameterizedTest
    @ArgumentsSource(pythNegArgumentsProvider.class)
    void pythNeg(long x, long y, long z) {
        Exception exc = assertThrows(ArithmeticException.class, () -> pyth.pythagoras(x, y, z));

        assertEquals(exc.getMessage(), "there is no such thing as a length less than or equal to zero");
    }

    @ParameterizedTest
    @ArgumentsSource(pythNonRectArgumentsProvider.class)
    void pythNonRect(long x, long y, long z) {
        assertFalse(pyth.pythagoras(x, y, z));
    }

    @Test
    void pythRdmLikelyFalse() {
        for (int i = 0; i < 1000; i++) {
            // Arrange

            // the odds of randomly generating a rectangle triangle seem very slim.

            // also, since they will be squared, we limit our RNG to ]0 ; sqrt(Long.MAX)]
            long sqrtMaxMinOne = 3_037_000_498L;
            long n1 = rdm.nextLong(sqrtMaxMinOne) + 1;
            long n2 = rdm.nextLong(sqrtMaxMinOne) + 1;
            long n3 = rdm.nextLong(sqrtMaxMinOne) + 1;
            LongStream.of(n1, n2, n3).forEach(x -> x = x < 0 ? x * (-1) : x);

            boolean tmp = (n1 * n1) + (n2 * n2) == (n3 * n3) || (n1 * n1) + (n3 * n3) == (n2 * n2) ||
                          (n3 * n3) + (n2 * n2) == (n1 * n1);

            // Act
            boolean actual = pyth.pythagoras(n1, n2, n3);

            // Assert
            assertEquals(tmp, actual);
        }
    }

    @Test
    void pythRdmLikelyTrue() {
        for (int i = 0; i < 1000; i++) {
            // Arrange

            // improving the odds of randomly generating a rectangle triangle, playing within ]0 ; 15]

            long n1 = rdm.nextLong(4) + 1;
            long n2 = rdm.nextLong(4) + 1;
            long n3 = rdm.nextLong(4) + 1;

            boolean tmp = (n1 * n1) + (n2 * n2) == (n3 * n3) || (n1 * n1) + (n3 * n3) == (n2 * n2) ||
                          (n3 * n3) + (n2 * n2) == (n1 * n1);

            // Act
            boolean actual = pyth.pythagoras(n1, n2, n3);

            // Assert
            assertEquals(tmp, actual);
        }
    }

}
