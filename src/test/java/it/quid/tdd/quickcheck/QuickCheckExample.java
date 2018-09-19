package it.quid.tdd.quickcheck;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import it.quid.tdd.Calculator;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

@RunWith(JUnitQuickcheck.class)
public class QuickCheckExample {

    @Property(trials = 500)
    public void testAddition(int number) {

        System.out.println("Generated number for testAddition: " + number);

        Calculator calculator = new Calculator();
        calculator.add(number);
        assertEquals(calculator.getResult(), number);
    }

    @Property(trials = 50)
    public void testAdditionUsingAssume(int number) {

        assumeThat(number, greaterThan(0));

        System.out.println("Generated number for testAdditionUsingAssume: " + number);

        Calculator calculator = new Calculator();
        calculator.add(number);
        assertEquals(calculator.getResult(), number);
    }

    @Property(trials = 500)
    public void testAdditionUsingInRange(@InRange(minInt = 0, maxInt = 100) int number) {

        System.out.println("Generated number for testAdditionUsingInRange: " + number);

        Calculator calculator = new Calculator();
        calculator.add(number);
        assertEquals(calculator.getResult(), number);
    }

    @Property(trials = 50)
    public void testAdditionUsingSatisfies(@When(satisfies = "#_ >= 0") int number) {

        System.out.println("Generated number for testAdditionUsingSatisfies: " + number);

        Calculator calculator = new Calculator();
        calculator.add(number);
        assertEquals(calculator.getResult(), number);
    }

}
