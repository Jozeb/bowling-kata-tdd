import java.util.ArrayList;

public class Game {
    private int score;

    private int rollsCount;

    private ArrayList<Integer> rolls;

    public Game() {
        this.rolls = new ArrayList<>();
    }

    public void roll(int i) throws GameHasEndedException {

        if(rollsCount>=20) {
            throw new GameHasEndedException();
        }
        rolls.add(i);
        rollsCount++;

    }

    public int score() {
        int score = 0;

        for (int i = 0; i < rolls.size(); i+=2) {
            int rollOne = rolls.get(i);
            int rollTwo = rolls.get(i + 1);

            if (isSpare(rollOne, rollTwo)) {
                score += 10 + rolls.get(i + 2);
            }
            if (!isSpare(rollOne, rollTwo)) {
                score += rollOne + rollTwo;
            }

        }

        return score;
    }

    private boolean isSpare(int rollOne, int rollTwo) {
        return  rollOne+rollTwo == 10;
    }
}
