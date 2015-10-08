package se.webstep.calc;

public class Calc {

    private double value;

    /**
     * Add a number to the current value
     *
     * @param number the number to add
     * @return the Calc instance
     */
    public Calc plus(double number) {
        this.value += number;
        return this;
    }

    /**
     * Substract a number from the current value
     *
     * @param number the number to substract
     * @return the Calc instance
     */
    public Calc minus(double number) {
        plus(-1D * number);
        return this;
    }

    /**
     * Return the current value
     *
     * @return the current value
     */
    public double result() {
        return value;
    }

    /**
     * Reset the current value
     *
     * @return the Calc instance
     */
    public Calc reset() {
        this.value = 0;
        return this;
    }
}
