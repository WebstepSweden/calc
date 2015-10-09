package se.webstep.calc.troll.exception;

public class TrollsDontDoNegativeNumbersException extends RuntimeException {

    public TrollsDontDoNegativeNumbersException(String message) {
        super(message);
    }

    public TrollsDontDoNegativeNumbersException(String message, Throwable cause) {
        super(message, cause);
    }
}
