package se.webstep.calc.exception;

/**
 * An exception that should be thrown when trying to construct a negative troll number
 */
public class TrollsDontDoNegativeNumbersException extends RuntimeException {

    public TrollsDontDoNegativeNumbersException(String message) {
        super(message);
    }
}
