package se.webstep.calc.troll.exception;

public class TrollsDontDoBigNumbersException extends RuntimeException {

    public TrollsDontDoBigNumbersException(String message) {
        super(message);
    }

    public TrollsDontDoBigNumbersException(String message, Throwable cause) {
        super(message, cause);
    }
}
