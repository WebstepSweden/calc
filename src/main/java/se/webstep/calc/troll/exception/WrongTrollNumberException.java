package se.webstep.calc.troll.exception;

/**
 * An exception that should be thrown when trying to parse a troll number without success,
 * such as when the textual representation does not match "ONE", "TWO", "THREE", "MANY", "MANY-ONE",
 * "MANY-MANY-THREE", "LOTS", etc.
 */
public class WrongTrollNumberException extends RuntimeException {

    public WrongTrollNumberException(String message) {
        super(message);
    }
}
