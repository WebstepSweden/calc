package se.webstep.calc.troll.number;

/**
 * A troll number, inspired by Terry Pratchett's Discworld description of how troll count.
 * <p>
 * This is how trolls count:
 * <p>
 * ONE, TWO, THREE, MANY<br>
 * MANY-ONE, MANY-TWO, MANY-THREE, MANY-MANY<br>
 * MANY-MANY-ONE, MANY-MANY-TWO, MANY-MANY-THREE, MANY-MANY-MANY<br>
 * MANY-MANY-MANY-ONE, MANY-MANY-MANY-TWO, MANY-MANY-MANY-THREE, LOTS
 * <p>
 * The following exceptions can be thrown while constructing a troll number:
 * <ul>
 * <li>{@link se.webstep.calc.troll.exception.WrongTrollNumberException} if the number cannot be parsed or is equal to zero</li>
 * <li>{@link se.webstep.calc.troll.exception.TrollsDontDoBigNumbersException} if the number is bigger than "LOTS" (16)</li>
 * <li>{@link se.webstep.calc.troll.exception.TrollsDontDoNegativeNumbersException} if the number is negative</li>
 * </ul>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Troll_(Discworld)#Literacy_and_Numeracy">Terry Pratchett's Discworld: Trolls - Literacy and Numeracy</a>
 */
public interface TrollNumber {

    /**
     * Get the numeric value of the troll number
     *
     * @return the numeric value of the troll number
     */
    int getValue();

    /**
     * Get the textual representation of the troll number
     *
     * @return the textual representation of the troll number
     */
    String getText();
}
