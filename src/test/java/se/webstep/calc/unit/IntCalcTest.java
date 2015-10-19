package se.webstep.calc.unit;

import org.junit.Before;
import org.junit.Test;
import se.webstep.calc.IntCalc;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class IntCalcTest {

    private IntCalc ic = new IntCalc();

    @Before
    public void doBeforeEachTest() {
        ic.reset();
    }

    @Test
    public void resetTest() throws Exception {
        assertThat(ic.result()).isEqualTo(0);
        ic.plus(3);
        ic.reset();
        assertThat(ic.result()).isEqualTo(0);
    }

    @Test
    public void addOneNumberTest() throws Exception {
        ic.plus(3);
        assertThat(ic.result()).isEqualTo(3);
    }

    @Test
    public void addTwoNumbersTest() throws Exception {
        ic.plus(3);
        ic.plus(5);
        assertThat(ic.result()).isEqualTo(8);
    }

    @Test
    public void addFiveNumbersTest() throws Exception {
        ic.plus(3);
        ic.plus(5);
        ic.plus(6);
        ic.plus(4);
        ic.plus(2);
        assertThat(ic.result()).isEqualTo(20);
    }

    @Test
    public void substractOneNumberTest() throws Exception {
        ic.minus(3);
        assertThat(ic.result()).isEqualTo(-3);
    }

    @Test
    public void substractTwoNumbersTest() throws Exception {
        ic.minus(3);
        ic.minus(5);
        assertThat(ic.result()).isEqualTo(-8);
    }

    @Test
    public void substractSixNumbersTest() throws Exception {
        ic.minus(3);
        ic.minus(5);
        ic.minus(4);
        ic.minus(5);
        ic.minus(6);
        ic.minus(9);
        assertThat(ic.result()).isEqualTo(-32);
    }

    @Test
    public void addAndSubstractSameNumberTest() throws Exception {
        ic.plus(3);
        ic.minus(3);
        assertThat(ic.result()).isEqualTo(0);
    }

    @Test
    public void addAndSubstractSeveralNumbersTest() throws Exception {
        ic.plus(3);
        ic.minus(4);
        ic.plus(5);
        ic.minus(6);
        ic.plus(7);
        ic.minus(8);
        assertThat(ic.result()).isEqualTo(-3);
    }

    @Test
    public void multiplyByZeroTest() throws Exception {
        ic.multiplyBy(0);
        assertThat(ic.result()).isEqualTo(0);
        ic.plus(3);
        ic.multiplyBy(0);
        assertThat(ic.result()).isEqualTo(0);
    }

    @Test
    public void multiplicationTest() throws Exception {
        ic.plus(3);
        ic.multiplyBy(3);
        assertThat(ic.result()).isEqualTo(9);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZeroTest() throws Exception {
        ic.divideBy(0);
    }

    @Test
    public void divisionAndMultiplicationTest() throws Exception {
        ic.plus(1234);
        ic.multiplyBy(4);
        ic.divideBy(4);
        assertThat(ic.result()).isEqualTo(1234);
    }

    @Test
    public void divisionTest() throws Exception {
        ic.plus(12);
        ic.divideBy(4);
        assertThat(ic.result()).isEqualTo(3);
    }
}
