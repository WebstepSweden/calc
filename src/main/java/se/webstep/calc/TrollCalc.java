package se.webstep.calc;

/**
 * A troll calculator, inspired by Terry Pratchett's Discworld description of how troll count.
 * <p>
 * This is how trolls count:
 * <p>
 * ONE, TWO, THREE, MANY<br>
 * MANY-ONE, MANY-TWO, MANY-THREE, MANY-MANY<br>
 * MANY-MANY-ONE, MANY-MANY-TWO, MANY-MANY-THREE, MANY-MANY-MANY<br>
 * MANY-MANY-MANY-ONE, MANY-MANY-MANY-TWO, MANY-MANY-MANY-THREE, LOTS
 * <p>
 * The troll calculator holds a current value and allows you to manipulate it using the following methods:
 * <ul>
 * <li>{@link #plus(String)} to add a number to the current value</li>
 * <li>{@link #minus(String)} to subtract a number from the current value</li>
 * <li>{@link #reset()} to reset the current value</li>
 * </ul>
 * <p>
 * Finally, use the
 * <ul>
 * <li>{@link #result()} method to fetch the current value</li>
 * </ul>
 * <p>
 * The following exceptions can be thrown while manipulating with the calculator:
 * <ul>
 * <li>{@link se.webstep.calc.exception.WrongTrollNumberException} if the number cannot be parsed or is equal to zero</li>
 * <li>{@link se.webstep.calc.exception.TrollsDontDoBigNumbersException} if the number is bigger than "LOTS" (16)</li>
 * <li>{@link se.webstep.calc.exception.TrollsDontDoNegativeNumbersException} if the number is negative</li>
 * </ul>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Troll_(Discworld)#Literacy_and_Numeracy">Terry Pratchett's Discworld: Trolls - Literacy and Numeracy</a>
 */
public class TrollCalc {

    private TrollNumber trollNumber;

    /**
     * Create a new instant of the calculator with an empty current value
     */
    public TrollCalc() {

    }

    /**
     * Add a number to the current value
     *
     * @param trollNumber the number to add
     */
    public void plus(String trollNumber) {
        int value = result() + TrollUtils.parseStringToTrollNumber(trollNumber).getValue();
        this.trollNumber = TrollUtils.parseIntToTrollNumber(value);
    }

    /**
     * Subtract a number from the current value
     *
     * @param trollNumber the number to subtract
     */
    public void minus(String trollNumber) {
        int value = result() - TrollUtils.parseStringToTrollNumber(trollNumber).getValue();
        this.trollNumber = TrollUtils.parseIntToTrollNumber(value);
    }

    /**
     * Return the current value
     *
     * @return the current value
     */
    public int result() {
        return trollNumber == null ? 0 : trollNumber.getValue();
    }

    /**
     * Reset the current value
     */
    public void reset() {
        trollNumber = null;
    }

    public String toString() {
        if (trollNumber == null) {
            return "";
        }

        return trollNumber.getText();
    }
}
