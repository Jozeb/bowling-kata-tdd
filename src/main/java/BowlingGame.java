import roll.RollingAfter;

import java.util.ArrayList;
import java.util.List;

import static roll.RollingAfter.DOUBLE_STRIKE;
import static roll.RollingAfter.SINGLE_STRIKE;
import static roll.RollingAfter.NORMAL;
import static roll.RollingAfter.SPARE;
import static roll.RollingAfter.STRIKE_THEN_NORMAL;

public class BowlingGame {

    public static final int NEW_FRAME = -1;
    List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        return recursiveScore(rolls, NEW_FRAME, NORMAL, 1);
    }

    public int recursiveScore(List<Integer> numbers, int previousRoll, RollingAfter rollingAfter, int frameNumber) {
        if (numbers.size() > 0) {
            if (isStrike(numbers, previousRoll) && (rollingAfter == SINGLE_STRIKE || rollingAfter == DOUBLE_STRIKE)) {
                return multiplyCurrentRoll(numbers, rollingAfter)
                        + recursiveScore(splitList(numbers), NEW_FRAME, DOUBLE_STRIKE, frameNumber + 1);
            }
            if (isStrike(numbers, previousRoll) && !(rollingAfter == SINGLE_STRIKE || rollingAfter == DOUBLE_STRIKE)) {
                return multiplyCurrentRoll(numbers, rollingAfter)
                        + recursiveScore(splitList(numbers), NEW_FRAME, SINGLE_STRIKE, frameNumber + 1);
            }
            if (rollingAfter == SINGLE_STRIKE) {
                return multiplyCurrentRoll(numbers, rollingAfter)
                        + recursiveScore(splitList(numbers), numbers.get(0), STRIKE_THEN_NORMAL, frameNumber);
            }
            if (isSpare(numbers, previousRoll) && frameNumber != 10) {
                return multiplyCurrentRoll(numbers, rollingAfter)
                        + recursiveScore(splitList(numbers), NEW_FRAME, SPARE, frameNumber + 1);
            }
            if (isNewFrame(previousRoll)) {
                return multiplyCurrentRoll(numbers, rollingAfter)
                        + recursiveScore(splitList(numbers), numbers.get(0), NORMAL, frameNumber);
            }
            return multiplyCurrentRoll(numbers, rollingAfter)
                    + recursiveScore(splitList(numbers), NEW_FRAME, NORMAL, frameNumber + 1);
        }
        return 0;
    }

    private boolean isStrike(List<Integer> numbers, int previousRoll) {
        return isNewFrame(previousRoll) && numbers.get(0) == 10;
    }

    private List<Integer> splitList(List<Integer> numbers) {
        return numbers.subList(1, numbers.size());
    }

    private int multiplyCurrentRoll(List<Integer> numbers, RollingAfter rollingAfter) {
        return rollingAfter.getMultiplier() * numbers.get(0);
    }

    private boolean isNewFrame(int previousRoll) {
        return previousRoll == NEW_FRAME;
    }

    private boolean isSpare(List<Integer> numbers, int previousRoll) {
        return numbers.get(0) + previousRoll == 10;
    }
}
