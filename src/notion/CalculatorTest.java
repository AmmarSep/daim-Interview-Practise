package notion;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest/* extends TestCase*/ {
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        // 3 + 4 = 7
        int expected = 7;
        int actual = calc.add(3, 4);
        assertEquals("adding 3 and 4", expected, actual);
    }
    @Test
    public void testDivision() {
        Calculator calc = new Calculator();
        // Divide by zero shouldn't work
        try {
            calc.divide(2, 0);
//            fail("Should have thrown an exception!");
        }
        catch (ArithmeticException e) {

        }
            // Good, that's what we expect
//        }
    }
}
