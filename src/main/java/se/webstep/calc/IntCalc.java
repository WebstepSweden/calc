package se.webstep.calc;

/**
 * Integer calculator. This calculator acts just as your good-old calculator did, many
 * years ago: it holds a state which is the current value, and allows value manipulation,
 * fetching and resetting of it.
 * <p>
 * Use the following methods to manipulate the value:
 * <ul>
 * <li>{@link #plus(Integer)} to add a number to the current value</li>
 * <li>{@link #minus(Integer)} to substract a number from the current value</li>
 * <li>{@link #multiplyBy(Integer)} to multiply the current value by a number</li>
 * <li>{@link #divideBy(Integer)} to divide the current value by a number</li>
 * <li>{@link #reset()} to reset the current value</li>
 * </ul>
 * <p>
 * Finally, use the
 * <ul>
 * <li>{@link #result()} method to fetch the current value</li>
 * </ul>
 */
public class IntCalc {

    private int value;

    /**
     * Create a new instant of the calculator with zero current value
     */
    public IntCalc() {

    }

    /**
     * Add a number to the current value
     *
     * @param number the number to add
     */
    public void plus(Integer number) {
        this.value += number;
    }

    /**
     * Subtract a number from the current value
     *
     * @param number the number to subtract
     */
    public void minus(Integer number) {
        plus(-1 * number);
    }

    /**
     * Multiply the current value by a given number
     *
     * @param number the number to multiply by
     */
    public void multiplyBy(Integer number) {
        this.value *= number;
    }

    /**
     * Divide the current value by a given number
     *
     * @param number the number to divide by
     */
    public void divideBy(Integer number) {
        this.value /= number;
    }

    /**
     * Return the current value
     *
     * @return the current value
     */
    public int result() {
        return value;
    }

    /**
     * Reset the current value
     */
    public void reset() {
        this.value = 0;
    }
}
