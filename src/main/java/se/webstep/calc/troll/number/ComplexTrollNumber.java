package se.webstep.calc.troll.number;

import java.util.List;
import java.util.stream.Collectors;

class ComplexTrollNumber implements TrollNumber {
    private List<SimpleTrollNumber> numbers;

    public ComplexTrollNumber(List<SimpleTrollNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int getValue() {
        return numbers.stream()
                .mapToInt(TrollNumber::getValue)
                .sum();
    }

    @Override
    public String getText() {

        if (getValue() == 16) {
            return "LOTS";
        }

        return numbers.stream()
                .map(TrollNumber::getText)
                .collect(Collectors.joining("-"));
    }
}
