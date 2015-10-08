package se.webstep.calc.troll.number;

public enum SimpleTrollNumber implements TrollNumber {

    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four");

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
}
