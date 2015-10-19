package se.webstep.calc.unit;

import org.junit.Test;
import se.webstep.calc.troll.exception.TrollsDontDoBigNumbersException;
import se.webstep.calc.troll.exception.TrollsDontDoNegativeNumbersException;
import se.webstep.calc.troll.exception.WrongTrollNumberException;
import se.webstep.calc.troll.number.TrollNumber;
import se.webstep.calc.troll.number.TrollUtils;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.Assert.fail;

public class TrollUtilsTest {

    // just to make the coverage more complete.
    // See discussion at http://stackoverflow.com/questions/4520216/how-to-add-test-coverage-to-a-private-constructor
    @Test
    public void trollUtilsConstructorShouldBePrivateTest() throws Exception {
        Constructor[] ctors = TrollUtils.class.getDeclaredConstructors();
        assertThat(ctors.length).isEqualTo(1);
        Constructor ctor = ctors[0];
        assertThat(ctor.isAccessible()).isFalse();
        ctor.setAccessible(true);
        assertThat(ctor.newInstance().getClass()).isEqualTo(TrollUtils.class);
    }

    @Test
    public void parseStringToTrollNumberTest() throws Exception {
        TrollNumber t1 = TrollUtils.parseStringToTrollNumber("THREE");
        assertThat(t1.getValue()).isEqualTo(3);
        assertThat(t1.getText()).isEqualTo("THREE");

        TrollNumber t2 = TrollUtils.parseStringToTrollNumber("MANY-MANY-THREE");
        assertThat(t2.getValue()).isEqualTo(11);
        assertThat(t2.getText()).isEqualTo("MANY-MANY-THREE");
    }

    @Test
    public void parseIntToTrollNumberTest() throws Exception {
        TrollNumber t1 = TrollUtils.parseIntToTrollNumber(2);
        assertThat(t1.getValue()).isEqualTo(2);
        assertThat(t1.getText()).isEqualTo("TWO");

        TrollNumber t2 = TrollUtils.parseIntToTrollNumber(5);
        assertThat(t2.getValue()).isEqualTo(5);
        assertThat(t2.getText()).isEqualTo("MANY-ONE");
    }

    @Test
    public void parseWrongStringTest() throws Exception {
        try {
            TrollUtils.parseStringToTrollNumber("");
            fail("Exception should hav been thrown");
        } catch (Exception e) {
            // ok!
        }

        try {
            TrollUtils.parseStringToTrollNumber("One");
            fail("Exception should hav been thrown");
        } catch (Exception e) {
            // ok!
        }

        try {
            TrollUtils.parseStringToTrollNumber("MANY_ONE");
            fail("Exception should hav been thrown");
        } catch (Exception e) {
            // ok!
        }

        try {
            TrollUtils.parseStringToTrollNumber("3");
            fail("Exception should hav been thrown");
        } catch (Exception e) {
            // ok!
        }
    }

    @Test(expected = WrongTrollNumberException.class)
    public void parseZeroTest() throws Exception {
        TrollUtils.parseIntToTrollNumber(0);
    }

    @Test(expected = TrollsDontDoBigNumbersException.class)
    public void parseTooBigNumberTest() {
        TrollUtils.parseIntToTrollNumber(17);
    }

    @Test(expected = TrollsDontDoNegativeNumbersException.class)
    public void parseNegativeNumberTest() {
        TrollUtils.parseIntToTrollNumber(-1);
    }
}
