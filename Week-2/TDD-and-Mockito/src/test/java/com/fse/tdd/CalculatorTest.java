package com.fse.tdd;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    private Calculator calculator;
    @BeforeEach void setUp() { calculator = new Calculator(); }
    @AfterEach void tearDown() { calculator = null; }
    @Test void addsNumbersUsingArrangeActAssert() { int actual = calculator.add(2, 3); assertEquals(5, actual); }
    @Test void rejectsDivisionByZero() { assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0)); }
}
