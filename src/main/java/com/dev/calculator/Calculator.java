package com.dev.calculator;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private final HashMap<Character, DoubleBinaryOperator> operations;

    public Calculator() {
        this.operations = new HashMap<>();
        this.operations.put('+', (a, b) -> (a + b));
        this.operations.put('-', (a, b) -> (a - b));
        this.operations.put('*', (a, b) -> (a * b));
        this.operations.put('/', (a, b) -> (a / b));
    }

    public double calculate(double a, double b, Character c) {
        DoubleBinaryOperator doubleBinaryOperator = operations.get(c);
        if (doubleBinaryOperator == null) {
            throw new IllegalArgumentException("Invalid operator selected");
        }
        return doubleBinaryOperator.applyAsDouble(a, b);
    }
}
