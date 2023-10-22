package edu.hw2;

import edu.hw2.Task1.Expr.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void TestConstant() {
        assertEquals(new Constant(2).evaluate(), 2);
    }

    @Test
    void TestNegate() {
        assertEquals(new Negate(new Constant(42)).evaluate(), -42);
    }

    @Test
    void TestAddition() {
        Constant fortyTwo = new Constant(42);
        assertEquals(new Addition(fortyTwo, new Negate(fortyTwo)).evaluate(), 0);
    }

    @Test
    void TestMultiplicationNegative() {
        Constant fortyTwo = new Constant(42);
        Negate minusTwo = new Negate(new Constant(-2));
        assertEquals(new Multiplication(fortyTwo, minusTwo).evaluate(), 84);
    }

    @Test
    void TestMultiplicationZero() {
        Constant fortyTwo = new Constant(42);
        Negate zero = new Negate(new Constant(0));
        assertEquals(new Multiplication(fortyTwo, zero).evaluate(), 0);
    }

    @Test
    void TestExponentZero() {
        Constant fortyTwo = new Constant(42);
        assertEquals(new Exponent(fortyTwo, 0).evaluate(), 1);
    }

    @Test
    void TestExponentNegative() {
        Constant two = new Constant(2);
        assertEquals(new Exponent(two, -2).evaluate(), 0.25);
    }

    @Test
    void TestExponentPositive() {
        Constant two = new Constant(2);
        assertEquals(new Exponent(two, 3).evaluate(), 8);
    }
}
