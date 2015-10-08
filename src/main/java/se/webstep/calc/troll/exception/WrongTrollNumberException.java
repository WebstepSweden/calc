package se.webstep.calc.troll.exception;

public class WrongTrollNumberException extends RuntimeException {

    public WrongTrollNumberException(String message) {
        super(message);
    }

    public WrongTrollNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
