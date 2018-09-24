package it.tdd.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenReceiveEmptyString() {
        assertEquals(new Integer(0), Calculator.add(""));
    }

    @Test
    public void shouldReturnInputValueWhenReceiveASingleNumber() {
        assertEquals(new Integer(5),Calculator.add("5"));
    }

    @Test
    public void shouldReturnSumWhenReceiveTwoCommaSeparatedNumbers() {
        assertEquals(new Integer(15),Calculator.add("10,5"));

    }

    @Test
    public void shouldReturnSumWhenReceiveTwoNewLineSeparatedNumbers() {
        assertEquals(new Integer(15),Calculator.add("10\n5"));
    }

    @Test
    public void shouldReturnSumWhenReceiveThreeCommaSeparatedNumbers() {
        assertEquals(new Integer(22),Calculator.add("10,5,7"));
    }

    @Test(expected = NegativeNumberException.class)
    public void shouldThrowExceptionWhenInputContainsNegativeNumbers() {
        Calculator.add("10,-3,98,-1");
    }

    @Test
    public void shouldIgnoreNumbersGreaterOrEqualsTo1000() {
        assertEquals(new Integer(15), Calculator.add("1,9,1500,1000,5"));
    }
}
