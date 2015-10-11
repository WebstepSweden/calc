package se.webstep.calc.unit;

import org.junit.Before;
import org.junit.Test;
import se.webstep.calc.TrollCalc;
import se.webstep.calc.troll.exception.TrollsDontDoBigNumbersException;

import static org.junit.Assert.assertEquals;

public class TrollCalcTest {

    TrollCalc tc = new TrollCalc();

    @Before
    public void doBeforeEachTest() {
        tc.reset();
    }

    @Test
    public void resetTest() throws Exception {
        assertEquals(0, tc.result());
        tc.plus("THREE");
        tc.reset();
        assertEquals(0, tc.result());
    }

    @Test
    public void addOneSimpleNumberTest() throws Exception {
        tc.plus("ONE");
        assertEquals(1, tc.result());
        assertEquals("ONE", tc.toString());
    }

    @Test
    public void addTwoSimpleNumbersTest() throws Exception {
        tc.plus("TWO");
        assertEquals(2, tc.result());
        assertEquals("TWO", tc.toString());

        tc.plus("TWO");
        assertEquals(4, tc.result());
        assertEquals("MANY", tc.toString());
    }

    @Test
    public void addSimpleNumbersToAComplexResultTest() throws Exception {
        tc.plus("TWO");
        tc.plus("THREE");
        assertEquals(5, tc.result());
        assertEquals("MANY-ONE", tc.toString());
    }

    @Test
    public void addASimpleNumberAndAComplexNumberTest() throws Exception {
        tc.plus("TWO");
        tc.plus("MANY-ONE");
        assertEquals(7, tc.result());
        assertEquals("MANY-THREE", tc.toString());
    }

    @Test
    public void addTwoComplexNumbersTest() throws Exception {
        tc.plus("MANY-MANY-TWO");
        tc.plus("MANY-ONE");
        assertEquals(15, tc.result());
        assertEquals("MANY-MANY-MANY-THREE", tc.toString());
    }

    @Test
    public void addBigNumbersTest() throws Exception {
        tc.plus("MANY-MANY-MANY");
        tc.plus("TWO");
        tc.plus("TWO");
        assertEquals(16, tc.result());
        assertEquals("LOTS", tc.toString());
    }

    @Test(expected = TrollsDontDoBigNumbersException.class)
    public void addTooBigNumbersTest() throws Exception {
        tc.plus("MANY-MANY-MANY");
        tc.plus("TWO");
        tc.plus("THREE");
    }
}
