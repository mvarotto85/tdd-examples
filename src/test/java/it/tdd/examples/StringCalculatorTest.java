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
}
