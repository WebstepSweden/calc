package se.webstep.calc;

import cucumber.api.java.da.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import org.junit.Assert;

public class IntCalcSteps {

    private Calc calc = new IntCalc();

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
        Assert.assertEquals(number, calc.result(), 0);
    }
}
