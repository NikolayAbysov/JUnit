package com.dev.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
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
    void wrongOperator() {
        try {
            calculator.calculate(1, 1, 'a');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assertions.fail("Runtime exception expected");
    }

    @Test
    void divideByZero() {
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(1, 0, '/'));
    }
}
