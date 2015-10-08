package se.webstep.calc;

import cucumber.api.java.da.Givet;
import cucumber.api.java.sv.När;
import cucumber.api.java.sv.Så;
import org.junit.Assert;

public class Stepdefs {

    private Calc calc = new Calc();

    @Givet("^jag nollställer miniräknaren$")
    public void i_reset_the_calculator() throws Throwable {
        calc.reset();
    }

    @När("^jag adderar (.+)$")
    public void i_add(double number) throws Throwable {
        calc.plus(number);
    }

    @Så("^ska resultatet vara (.+)$")
    public void result_should_be(double number) throws Throwable {
        Assert.assertEquals(number, calc.result(), 0);
    }
}
