import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        return recursiveScore(rolls, 0, 1);
    }

    public int recursiveScore(List<Integer> numbers, int previousRoll, int multiplier) {
        if (numbers.size() > 0) {
            if (numbers.get(0) + previousRoll == 10) {
                return multiplier * numbers.get(0)
                        + recursiveScore(numbers.subList(1, numbers.size()), 0, 2);
            }
            return multiplier * numbers.get(0)
                    + recursiveScore(numbers.subList(1, numbers.size()), numbers.get(0), 1);
        }
        return 0;
    }
}
