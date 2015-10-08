package se.webstep.calc.troll.util;

import se.webstep.calc.troll.number.ComplexTrollNumber;
import se.webstep.calc.troll.number.TrollNumber;
import se.webstep.calc.troll.number.SimpleTrollNumber;
import se.webstep.calc.troll.exception.WrongTrollNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrollUtils {

    private TrollUtils() {
    }

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
}
