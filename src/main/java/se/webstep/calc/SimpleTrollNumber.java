package se.webstep.calc;

import se.webstep.calc.exception.WrongTrollNumberException;

import java.util.Arrays;
import java.util.Optional;

enum SimpleTrollNumber implements TrollNumber {

    ONE(1, "ONE"),
    TWO(2, "TWO"),
    THREE(3, "THREE"),
    MANY(4, "MANY"),
    LOTS(16, "LOTS");

    private int value;
    private String text;

    SimpleTrollNumber(int value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }

    public static SimpleTrollNumber getFromValue(int value) {
        Optional<SimpleTrollNumber> trollNumber = Arrays.stream(values())
                .filter(v -> v.value == value)
                .findFirst();

        if (trollNumber.isPresent()) {
            return trollNumber.get();
        } else {
            throw new WrongTrollNumberException("Troll don't think " + value + " is troll number");
        }
    }
}
