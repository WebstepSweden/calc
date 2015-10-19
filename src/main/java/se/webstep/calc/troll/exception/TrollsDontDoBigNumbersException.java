package se.webstep.calc.troll.exception;

/**
 * An exception that should be thrown when trying to construct a troll number that is bigger than "LOTS", or 16
 */
public class TrollsDontDoBigNumbersException extends RuntimeException {

    public TrollsDontDoBigNumbersException(String message) {
        super(message);
    }
}
