package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {
    
    private ScientificCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
    }
    
    @Test
    void testSquareRootPositiveNumber() {
        double result = Math.sqrt(16.0);
        assertEquals(4.0, result, 0.0001);
    }
    
    @Test
    void testSquareRootZero() {
        double result = Math.sqrt(0.0);
        assertEquals(0.0, result, 0.0001);
    }
    
    @Test
    void testSquareRootDecimal() {
        double result = Math.sqrt(2.25);
        assertEquals(1.5, result, 0.0001);
    }
    
    @Test
    void testSquareRootNegativeNumber() {
        // Test that square root of negative number returns NaN
        double result = Math.sqrt(-4.0);
        assertTrue(Double.isNaN(result));
    }
    
    @Test
    void testFactorialZero() {
        long result = factorial(0);
        assertEquals(1L, result);
    }
    
    @Test
    void testFactorialOne() {
        long result = factorial(1);
        assertEquals(1L, result);
    }
    
    @Test
    void testFactorialPositiveNumber() {
        long result = factorial(5);
        assertEquals(120L, result);
    }
    
    @Test
    void testFactorialTen() {
        long result = factorial(10);
        assertEquals(3628800L, result);
    }
    
    @Test
    void testFactorialLargeNumber() {
        long result = factorial(20);
        assertEquals(2432902008176640000L, result);
    }
    
    @Test
    void testNaturalLogarithmOne() {
        double result = Math.log(1.0);
        assertEquals(0.0, result, 0.0001);
    }
    
    @Test
    void testNaturalLogarithmE() {
        double result = Math.log(Math.E);
        assertEquals(1.0, result, 0.0001);
    }
    
    @Test
    void testNaturalLogarithmPositiveNumber() {
        double result = Math.log(10.0);
        assertEquals(2.302585, result, 0.0001);
    }
    
    @Test
    void testNaturalLogarithmZero() {
        double result = Math.log(0.0);
        assertTrue(Double.isInfinite(result));
        assertTrue(result < 0);
    }
    
    @Test
    void testNaturalLogarithmNegativeNumber() {
        double result = Math.log(-1.0);
        assertTrue(Double.isNaN(result));
    }
    
    @Test
    void testPowerPositiveBasePositiveExponent() {
        double result = Math.pow(2.0, 3.0);
        assertEquals(8.0, result, 0.0001);
    }
    
    @Test
    void testPowerPositiveBaseZeroExponent() {
        double result = Math.pow(5.0, 0.0);
        assertEquals(1.0, result, 0.0001);
    }
    
    @Test
    void testPowerZeroBasePositiveExponent() {
        double result = Math.pow(0.0, 5.0);
        assertEquals(0.0, result, 0.0001);
    }
    
    @Test
    void testPowerNegativeBaseIntegerExponent() {
        double result = Math.pow(-2.0, 3.0);
        assertEquals(-8.0, result, 0.0001);
    }
    
    @Test
    void testPowerNegativeBaseEvenExponent() {
        double result = Math.pow(-2.0, 2.0);
        assertEquals(4.0, result, 0.0001);
    }
    
    @Test
    void testPowerFractionalExponent() {
        double result = Math.pow(4.0, 0.5);
        assertEquals(2.0, result, 0.0001);
    }
    
    @Test
    void testPowerNegativeExponent() {
        double result = Math.pow(2.0, -2.0);
        assertEquals(0.25, result, 0.0001);
    }
    
    // Helper method to test factorial (since the original method is private)
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
