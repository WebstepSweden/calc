package se.webstep.calc.unit;

import org.junit.Before;
import org.junit.Test;
import se.webstep.calc.TrollCalc;
import se.webstep.calc.exception.TrollsDontDoBigNumbersException;
import se.webstep.calc.exception.TrollsDontDoNegativeNumbersException;
import se.webstep.calc.exception.WrongTrollNumberException;

import static org.assertj.core.api.Assertions.assertThat;

public class TrollCalcTest {

    TrollCalc tc = new TrollCalc();

    @Before
    public void doBeforeEachTest() {
        tc.reset();
    }

    @Test
    public void resetTest() throws Exception {
        assertThat(tc.result()).isEqualTo(0);
        tc.plus("THREE");
        tc.reset();
        assertThat(tc.result()).isEqualTo(0);
    }

    @Test
    public void addOneSimpleNumberTest() throws Exception {
        tc.plus("ONE");
        assertThat(tc.result()).isEqualTo(1);
        assertThat(tc.toString()).isEqualTo("ONE");
    }

    @Test
    public void addTwoSimpleNumbersTest() throws Exception {
        tc.plus("TWO");
        assertThat(tc.result()).isEqualTo(2);
        assertThat(tc.toString()).isEqualTo("TWO");

        tc.plus("TWO");
        assertThat(tc.result()).isEqualTo(4);
        assertThat(tc.toString()).isEqualTo("MANY");
    }

    @Test
    public void addSimpleNumbersToAComplexResultTest() throws Exception {
        tc.plus("TWO");
        tc.plus("THREE");
        assertThat(tc.result()).isEqualTo(5);
        assertThat(tc.toString()).isEqualTo("MANY-ONE");
    }

    @Test
    public void addASimpleNumberAndAComplexNumberTest() throws Exception {
        tc.plus("TWO");
        tc.plus("MANY-ONE");
        assertThat(tc.result()).isEqualTo(7);
        assertThat(tc.toString()).isEqualTo("MANY-THREE");
    }

    @Test
    public void addTwoComplexNumbersTest() throws Exception {
        tc.plus("MANY-MANY-TWO");
        tc.plus("MANY-ONE");
        assertThat(tc.result()).isEqualTo(15);
        assertThat(tc.toString()).isEqualTo("MANY-MANY-MANY-THREE");
    }

    @Test
    public void addBigNumbersTest() throws Exception {
        tc.plus("MANY-MANY-MANY");
        tc.plus("TWO");
        tc.plus("TWO");
        assertThat(tc.result()).isEqualTo(16);
        assertThat(tc.toString()).isEqualTo("LOTS");
    }

    @Test(expected = TrollsDontDoBigNumbersException.class)
    public void addTooBigNumbersTest() throws Exception {
        tc.plus("MANY-MANY-MANY");
        tc.plus("TWO");
        tc.plus("THREE");
    }

    @Test
    public void substractSimpleNumberTest() throws Exception {
        tc.plus("THREE");
        tc.minus("ONE");
        assertThat(tc.result()).isEqualTo(2);
        assertThat(tc.toString()).isEqualTo("TWO");
    }

    @Test
    public void substractComplexNumberTest() throws Exception {
        tc.plus("LOTS");
        tc.minus("MANY-ONE");
        assertThat(tc.result()).isEqualTo(11);
        assertThat(tc.toString()).isEqualTo("MANY-MANY-THREE");
    }

    @Test
    public void substractTwoSimpleNumbersTest() throws Exception {
        tc.plus("MANY");
        tc.minus("ONE");
        tc.minus("TWO");
        assertThat(tc.result()).isEqualTo(1);
        assertThat(tc.toString()).isEqualTo("ONE");
    }

    @Test
    public void substractASimpleAndAComplexNumberTest() throws Exception {
        tc.plus("LOTS");
        tc.minus("MANY-ONE");
        tc.minus("TWO");
        assertThat(tc.result()).isEqualTo(9);
        assertThat(tc.toString()).isEqualTo("MANY-MANY-ONE");
    }

    @Test
    public void substractTwoComplexNumbersTest() throws Exception {
        tc.plus("LOTS");
        tc.minus("MANY-ONE");
        tc.minus("MANY-MANY-TWO");
        assertThat(tc.result()).isEqualTo(1);
        assertThat(tc.toString()).isEqualTo("ONE");
    }

    @Test(expected = WrongTrollNumberException.class)
    public void substractionThatResultsInZeroShouldThrowExceptionTest() throws Exception {
        tc.plus("THREE");
        tc.minus("THREE");
    }

    @Test(expected = TrollsDontDoNegativeNumbersException.class)
    public void substractionThatResultsInANegativeNumberShouldThrowExceptionTest() throws Exception {
        tc.plus("THREE");
        tc.minus("MANY");
    }
}
