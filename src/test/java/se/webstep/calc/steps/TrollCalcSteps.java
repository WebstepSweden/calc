package se.webstep.calc.steps;

import cucumber.api.java.sv.Givet;
import cucumber.api.java.sv.Så;
import org.junit.Assert;
import se.webstep.calc.TrollCalc;

public class TrollCalcSteps {

    private TrollCalc calc = new TrollCalc();

    @Givet("^jag nollställer trollminiräknaren$")
    public void i_reset_the_calculator() throws Throwable {
        calc.reset();
    }

    @Så("^ska trollresultatet vara (\\d+)$")
    public void result_should_be(int number) throws Throwable {
        Assert.assertEquals(number, calc.result(), 0);
    }
}
