package it.tdd.examples;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.*;

@RunWith(JUnitQuickcheck.class)
public class StringCalculatorGenerativeTest {


    @Property(trials = 50)
    public void shouldBeAbleToSumCustomSeparatedNumbers(@When(seed = 1) List<@InRange(min = "0", max = "999")Integer> values, @When(seed = 1)String separator) {
        common(values, separator);

    }

    @Property(trials = 10)
    public void shouldBeAbleToSumCommaSeparatedNumbers(@When(seed = 1) List<@InRange(min = "0", max = "999")Integer> values) {
        common(values, ",");

    }

    private void common(List<@InRange(min = "0", max = "999") Integer> values, String separator) {
        assumeThat(values.size(), greaterThan(2));
        assumeNotNull(separator);
        assumeFalse(separator.contains("\n"));
        assumeFalse(separator.contains("\r"));



        String expression = "//" + separator + "\n" +
                values.stream()
                        .map(i -> i + separator)
                        .reduce((s1, s2) -> s1 + s2).orElse("");


        Integer expectedSum = values.stream().reduce((a, b) -> a + b).orElse(0);
        assertEquals(expectedSum, Calculator.add(expression));
    }
}
