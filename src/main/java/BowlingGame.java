import roll.Pins;
import roll.Roll;
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
    List<Roll> rollsList = new ArrayList<>();

    public void roll(Pins pins) {
        rollsList.add(Roll.roll(pins));
    }

    public int score() {
        return recursiveScore(rollsList, NEW_FRAME, NORMAL, 1);
    }

    public int recursiveScore(List<Roll> rolls, int previousRoll, RollingAfter rollingAfter, int frameNumber) {
        if (rolls.size() == 0) {
            return 0;
        }

        int score = multiplyCurrentRoll(rolls, rollingAfter);
        if (isStrike(rolls, previousRoll) && rollingAfter.strike() && frameNumber != 10) {
            return score
                    + recursiveScore(splitList(rolls), NEW_FRAME, DOUBLE_STRIKE, frameNumber + 1);
        }
        if (isStrike(rolls, previousRoll) && rollingAfter.notStrike() && frameNumber != 10) {
            return score
                    + recursiveScore(splitList(rolls), NEW_FRAME, SINGLE_STRIKE, frameNumber + 1);
        }
        if (rollingAfter.strike()) {
            return score
                    + recursiveScore(splitList(rolls), rolls.get(0).getPins().getPins(), STRIKE_THEN_NORMAL, frameNumber);
        }
        if (isSpare(rolls, previousRoll) && frameNumber != 10) {
            return score
                    + recursiveScore(splitList(rolls), NEW_FRAME, SPARE, frameNumber + 1);
        }
        if (isNewFrame(previousRoll)) {
            return score
                    + recursiveScore(splitList(rolls), rolls.get(0).getPins().getPins(), NORMAL, frameNumber);
        }
        return score
                + recursiveScore(splitList(rolls), NEW_FRAME, NORMAL, frameNumber + 1);

    }

    private boolean isStrike(List<Roll> rolls, int previousRoll) {
        return isNewFrame(previousRoll) && rolls.get(0).getPins().getPins() == 10;
    }

    private List<Roll> splitList(List<Roll> numbers) {
        return numbers.subList(1, numbers.size());
    }

    private int multiplyCurrentRoll(List<Roll> numbers, RollingAfter rollingAfter) {
        return rollingAfter.getMultiplier() * numbers.get(0).getPins().getPins();
    }

    private boolean isNewFrame(int previousRoll) {
        return previousRoll == NEW_FRAME;
    }

    private boolean isSpare(List<Roll> numbers, int previousRoll) {
        return numbers.get(0).getPins().getPins() + previousRoll == 10;
    }
}
