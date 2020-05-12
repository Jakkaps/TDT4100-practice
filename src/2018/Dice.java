import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Represents a set of die values. A die has six possible values 1-6,
 * but the number of dice may vary from Dice instance to Dice instance.
 * In addition, a Dice-instance can have a score.
 */
public class Dice implements Iterable<Integer> {
    /**
     * @param dieCount
     * @return a collection of random integer values in the range 1-6
     */
    public static Collection<Integer> randomDieValues(int dieCount) {
        Collection<Integer> randomDieValues = new ArrayList<>();

        for (int i = 0; i < dieCount; i++) {
            randomDieValues.add((int) Math.floor(Math.random() * 6) + 1);
        }

        return randomDieValues;
    }

    private List<Integer> dieValues;
    private int score = -1;

    /** (part 1)
     * Initializes this Dice with the values in dieValues, and a score.
     *  dieValues
     *  score the score to set, may be -1 for yet unknown
     *   suitable exception if the die values are outside the valid range
     */
    public Dice(Collection<Integer> dieValues, int score) {
        this.dieValues = new ArrayList<Integer>(dieValues);
        this.score = score;
    }

    public Dice(Supplier<Integer> die, int dieCount) {
        for (int i = 0; i < dieCount; i++) {
            this.dieValues.add(die.get());
        }
    }

    /** (part 1)
     * Initializes this Dice with dieCount random values (using Math.random())
     * @param dieCount
     */
    public Dice(int dieCount) {
        this.dieValues = new ArrayList<Integer>(randomDieValues(dieCount));
    }

    /** (part 1)
     * Initializes this Dice with the values in dice, and a score
     * @param dice // Denne skulle vært bare "dice", ikke "dieValues"
     * @param score the score to set, may be -1 for yet unknown
     */
    public Dice(Dice dice, int score) {
        this.dieValues = dice.dieValues;
        this.score = score;
    }

    /** (part 2)
     * Format: [die1, die2, ...] = score (score is omitted when < 0)
     */

    @Override
    public String toString() {
        String returnString = "";
        returnString += dieValues;
        returnString += score >= 0 ? " = " + score : "";
        return returnString;
    }

    /** (part 2)
     * Parses a string using the toString format (see above) and
     * returns a corresponding Dice.
     * @param s
     * @return a new Dice instance initialized with die values and score from the String argument
     */
    public static Dice valueOf(String s) {
        return new Dice(Arrays.asList(6, 6, 6), 600);
    }

    /** (part 3)
     * @return the number of die values
     */
    public int getDieCount() {
      return this.dieValues.size();
    }

    /** (part 3)
     * @param dieNum
     * @return the value of die number dieNum
     */
    public int getDieValue(int dieNum) {
        return this.dieValues.get(dieNum);
    }

    /** (part 3)
     * @param value
     * @return the number of dice with the provided value
     */
    public int getValueCount(int value) {
        return (int) dieValues.stream().filter(die -> die == value).count();
    }

    /** (part 4)
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /** (part 4)
     * Sets the score, but only if it isn't already set to a non-negative value
     * @param score
     * @throws a suitable exception if score already is set to a non-negative value
     */
    public void setScore(int score) {
        this.score = score;
    }

   // ... Iterable methods (part 5) ...

    /** (part 6) // Denne ble det ikke spurt om, og det var ikke meningen at den skulle implementeres, men den kunne brukes
     * @param dice
     * @return true if all die values in the argument appear in this Dice
     */
    public boolean contains(Dice dice) {
        return true;
    }

    /** (part 6)
     * @param dice a Collection of Dice // Denne linja var feil, det skulle være bare "dice a Dice"
     * @return a new Dice instance with the all the die values this Dice and
     * all Dice in the argument, without any specific order
     */
    public Dice add(Dice dice) {
        List<Integer> newDieValues = new ArrayList<>();
        newDieValues.addAll(dice.dieValues);
        newDieValues.addAll(this.dieValues);
        return new Dice(newDieValues, -1);
    }

    /** (part 6)
     * @param dice
     * @return a new Dice instance with the die values from this Dice, but
     * without those from the argument, without any specific order
     */
    public Dice remove(Dice dice) {
        return new Dice(this.dieValues.stream().filter(die -> !dice.dieValues.contains(die)).collect(Collectors.toList()), -1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return dieValues.iterator();
    }

    public static void main(String[] args){
        Dice dice = new Dice(Arrays.asList(6, 5, 6), 600);
        System.out.println(dice);

        for (Integer die : dice){
            System.out.println(die);
        }

        Dice newDice = new Dice(Arrays.asList(2), 1);
        System.out.println(dice.add(newDice));
    }
}