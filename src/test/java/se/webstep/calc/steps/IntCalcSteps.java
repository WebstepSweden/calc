package se.webstep.calc.steps;

import cucumber.api.java.da.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import se.webstep.calc.IntCalc;

import static org.assertj.core.api.Assertions.assertThat;

public class IntCalcSteps {

    private IntCalc calc = new IntCalc();

    @Givet("^jag nollställer miniräknaren$")
    public void i_reset_the_calculator() throws Throwable {
        calc.reset();
    }

    @När("^jag adderar (\\d+)$")
    public void i_add(int number) throws Throwable {
        calc.plus(number);
    }

    @När("^jag subtraherar (.*)$")
    public void i_subtract(int number) throws Throwable {
        calc.minus(number);
    }

    @När("^jag multiplicerar med (.*)$")
    public void i_multipliply_by(int number) throws Throwable {
        calc.multiplyBy(number);
    }

    @När("^jag dividerar med (.*)$")
    public void i_divide_by(int number) throws Throwable {
        calc.divideBy(number);
    }

    @Så("^ska resultatet vara (.*)$")
    public void result_should_be(int number) throws Throwable {
        assertThat(calc.result()).isEqualTo(number);
    }
}
