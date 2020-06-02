package com.dev.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addOperationOk() {
        Assertions.assertEquals(2, calculator.calculate(1, 1, '+'));
    }

    @Test
    void subtractOperationOk() {
        Assertions.assertEquals(0, calculator.calculate(1, 1, '-'));
    }

    @Test
    void multiplyOperationOk() {
        Assertions.assertEquals(9, calculator.calculate(3, 3, '*'));
    }

    @Test
    void divideOperationOk() {
        Assertions.assertEquals(4, calculator.calculate(16, 4, '/'));
    }

    @Test
    void powOperationOk() {
        Assertions.assertEquals(25, calculator.calculate(5, 2, '^'));
    }

    @Test
    void wrongOperator() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            calculator.calculate(1, 1, 'a');
        });
    }

    @Test
    void divideByZero() {
        Assertions.assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(1, 0, '/'));
    }

    @Test
    void sumInfinity() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY,
                calculator.calculate(1, Double.NEGATIVE_INFINITY, '+'));
    }

    @Test
    void subtractInfinity() {
        Assertions.assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(1, Double.NEGATIVE_INFINITY, '-'));
    }

    @Test
    void multiplyInfinity() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY,
                calculator.calculate(1, Double.NEGATIVE_INFINITY, '*'));
    }

    @Test
    void divideInfinity() {
        Assertions.assertEquals(-0.0,
                calculator.calculate(1, Double.NEGATIVE_INFINITY, '/'));
    }

    @Test
    void powInfinity() {
        Assertions.assertEquals(Double.NaN,
                calculator.calculate(1, Double.NEGATIVE_INFINITY, '^'));
    }

}
