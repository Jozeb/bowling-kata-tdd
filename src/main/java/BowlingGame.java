import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int NEW_FRAME = -1;
    List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        return recursiveScore(rolls, NEW_FRAME, 1);
    }

    public int recursiveScore(List<Integer> numbers, int previousRoll, int multiplier) {
        if (numbers.size() > 0) {
            if (isSpare(numbers, previousRoll)) {
                return multiplyCurrentRoll(numbers, multiplier)
                        + recursiveScore(splitList(numbers), NEW_FRAME, 2);
            }
            if (isNewFrame(previousRoll)) {
                return multiplyCurrentRoll(numbers, multiplier)
                        + recursiveScore(splitList(numbers), numbers.get(0), 1);
            }
            return multiplyCurrentRoll(numbers, multiplier)
                    + recursiveScore(splitList(numbers), NEW_FRAME, 1);
        }
        return 0;
    }

    private List<Integer> splitList(List<Integer> numbers) {
        return numbers.subList(1, numbers.size());
    }

    private int multiplyCurrentRoll(List<Integer> numbers, int multiplier) {
        return multiplier * numbers.get(0);
    }

    private boolean isNewFrame(int previousRoll) {
        return previousRoll == NEW_FRAME;
    }

    private boolean isSpare(List<Integer> numbers, int previousRoll) {
        return numbers.get(0) + previousRoll == 10;
    }
}
