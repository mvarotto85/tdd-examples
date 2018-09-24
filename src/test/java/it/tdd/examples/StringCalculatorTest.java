package it.tdd.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenReceiveEmptyString() {
        assertEquals(new Integer(0), Calculator.add(""));
    }



}
