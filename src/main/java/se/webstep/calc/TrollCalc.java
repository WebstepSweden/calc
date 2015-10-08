package se.webstep.calc;

import se.webstep.calc.troll.number.TrollNumber;
import se.webstep.calc.troll.util.TrollUtils;

public class TrollCalc {

    private TrollNumber trollNumber;

    public void plus(String trollNumber) {
        this.trollNumber = TrollUtils.parseTrollNumbers(trollNumber);
    }

    public void minus(TrollNumber number) {

    }

    public int result() {
        return trollNumber == null ? 0 : trollNumber.getValue();
    }

    public void reset() {
        trollNumber = null;
    }

    public String toString() {
        return trollNumber.getText();
    }
}
