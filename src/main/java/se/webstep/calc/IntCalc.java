package se.webstep.calc;

public class IntCalc {

    private int value;

    /**
     * Add a number to the current value
     *
     * @param number the number to add
     */
    public void plus(Integer number) {
        this.value += number;
    }

    /**
     * Substract a number from the current value
     *
     * @param number the number to substract
     */
    public void minus(Integer number) {
        plus(-1 * number);
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
