package se.webstep.calc.steps;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.PendingException;
import cucumber.api.java.sv.Givet;
import cucumber.api.java.sv.Och;
import cucumber.api.java.sv.Så;
import se.webstep.calc.TrollCalc;

public class TrollCalcSteps {

    private TrollCalc calc = new TrollCalc();
    private Exception thrownException;

    @Givet("^jag nollställer trollminiräknaren$")
    public void i_reset_the_calculator() throws Throwable {
        calc.reset();
    }

    @Så("^ska trollresultatet vara (\\d+)$")
    public void result_should_be(int number) throws Throwable {
        assertThat(calc.result()).isEqualTo(number);
    }

    @Givet("^att jag adderar heltalen \"([^\"]*)\" och \"([^\"]*)\"$")
    public void att_jag_anger_heltalen_och(String arg1, String arg2) throws Throwable {
            calc.plus(arg1);
            calc.plus(arg2);
    }

    @Så("^ska trollresultatet vara \"([^\"]*)\"$")
    public void ska_trollresultatet_vara(String resultat) throws Throwable {
        assertThat(calc.toString()).isEqualTo(resultat);
    }

    @Så("^ska trollresultatet vara \"([^\"]*)\" och (\\d+)$")
    public void ska_trollresultatet_vara_och(String arg1, int arg2) throws Throwable {
        assertThat(calc.toString()).isEqualTo(arg1);
        assertThat(calc.result()).isEqualTo(arg2);
    }

    @Och("^\"([^\"]*)\" är större än (\\d+)$")
    public void ärStörreÄn(String arg0, int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Givet("^att jag adderar heltalen \"([^\"]*)\" och \"([^\"]*)\" och \"([^\"]*)\" är större än (\\d+)$")
    public void attJagAdderarHeltalenOchOchÄrStörreÄn(String arg0, String arg1, String arg2, int arg3) throws Throwable {
        try {
            calc.plus(arg0);
            calc.plus(arg1);
        } catch (Exception up) {
            this.thrownException = up;
        }
    }

    @Så("^skall \"([^\"]*)\" visas")
    public void skallKastas(String expectedException) throws Throwable {
        assertThat(thrownException.getMessage()).isEqualTo(expectedException);
    }

    @Givet("^att jag subtraherar heltalen \"([^\"]*)\" och \"([^\"]*)\"$")
    public void attJagSubtraherarHeltalenOchMed(String arg0, String arg1) throws Throwable {
      try {
          calc.plus(arg0);
          calc.minus(arg1);
      } catch (Exception up) {
          thrownException = up;
      }
    }
}
