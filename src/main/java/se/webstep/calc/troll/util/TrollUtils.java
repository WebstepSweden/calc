package se.webstep.calc.troll.util;

import se.webstep.calc.troll.exception.TrollsDontDoBigNumbersException;
import se.webstep.calc.troll.exception.TrollsDontDoNegativeNumbersException;
import se.webstep.calc.troll.exception.WrongTrollNumberException;
import se.webstep.calc.troll.number.ComplexTrollNumber;
import se.webstep.calc.troll.number.SimpleTrollNumber;
import se.webstep.calc.troll.number.TrollNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Help methods for the TrollNumber classes
 */
public class TrollUtils {

    private TrollUtils() {
        // I'm a util class, don't instantiate me please
    }

    /**
     * Parse a String into a TrollNumber
     *
     * @param trollNumber the String to parse
     * @return a TrollNumber
     * @throws WrongTrollNumberException if the String could not be parsed
     */
    public static TrollNumber parseTrollNumbers(String trollNumber) {
        if (trollNumber == null || trollNumber.isEmpty()) {
            throw new WrongTrollNumberException("Troll number is empty. Human is stupid.");
        }

        List<SimpleTrollNumber> trollNumbers = Arrays.stream(trollNumber.split("-"))
                .map(tn -> {
                    try {
                        return SimpleTrollNumber.valueOf(tn);
                    } catch (IllegalArgumentException e) {
                        throw new WrongTrollNumberException("Troll number " + tn + " is no good. Human is confused?");
                    }
                })
                .collect(Collectors.toList());

        if (trollNumbers.size() == 1) {
            return trollNumbers.get(0);
        } else {
            return new ComplexTrollNumber(trollNumbers);
        }
    }

    /**
     * Parse an int into a TrollNumber
     *
     * @param trollNumber the int to parse
     * @return a TrollNumber
     * @throws TrollsDontDoNegativeNumbersException if the int is negative
     * @throws TrollsDontDoBigNumbersException      if the int is too big
     */
    public static TrollNumber parseTrollNumber(int trollNumber) {
        checkForTooSmallOrTooBigNumbers(trollNumber);

        int numberOfManys = trollNumber / 4;
        int rest = trollNumber % 4;

        if (numberOfManys > 0) {
            List<SimpleTrollNumber> trollNumbers = Stream.generate(() -> SimpleTrollNumber.MANY)
                    .limit(numberOfManys)
                    .collect(Collectors.toList());
            if (rest > 0) {
                trollNumbers.add(SimpleTrollNumber.getFromValue(rest));
            }
            return new ComplexTrollNumber(trollNumbers);
        }

        return SimpleTrollNumber.getFromValue(rest);
    }

    /**
     * Check if a number is too big or too small for a troll to grasp
     *
     * @param number the number to check
     * @throws TrollsDontDoNegativeNumbersException if the int is negative
     * @throws TrollsDontDoBigNumbersException      if the int is too big
     */
    public static void checkForTooSmallOrTooBigNumbers(int number) {
        if (number < 0) {
            throw new TrollsDontDoNegativeNumbersException("Trolls don't get " + number);
        }

        if (number > 16) {
            throw new TrollsDontDoBigNumbersException("Trolls don't get " + number);
        }
    }
}
