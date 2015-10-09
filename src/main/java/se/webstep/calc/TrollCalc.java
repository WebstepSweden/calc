package se.webstep.calc;

import se.webstep.calc.troll.number.TrollNumber;
import se.webstep.calc.troll.util.TrollUtils;

public class TrollCalc {

    private TrollNumber trollNumber;

    public void plus(String trollNumber) {
        int value = result() + TrollUtils.parseTrollNumbers(trollNumber).getValue();
        this.trollNumber = TrollUtils.parseTrollNumber(value);
    }

    public void minus(String trollNumber) {

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
