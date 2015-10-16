package se.webstep.calc.steps;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.da.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import se.webstep.calc.IntCalc;

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

    @Så("^ska resultatet vara (\\d+)$")
    public void result_should_be(int number) throws Throwable {
        assertThat(calc.result()).isEqualTo(number);
    }
}
