import exceptions.GameException;
import exceptions.GameHasEndedException;
import exceptions.InvalidRollException;

import java.util.ArrayList;

public class Game {

    private int rollsCount;

    private ArrayList<Integer> rolls;

    public Game() {
        this.rolls = new ArrayList<>();
    }

    public void roll(int i) throws GameException {

        if(i>10){
          throw  new InvalidRollException();
        }
        if(rollsCount>=20) {
            throw new GameHasEndedException();
        }
        rolls.add(i);
        rollsCount++;
    }

    public int score() {
        ArrayList<Frame> frames = new ArrayList<>();
        for (int i = 0; i < rolls.size(); ) {
            int rollOne = rolls.get(i);

            if (rollOne == 10) {
                Frame frame = new Frame(rollOne);
                frames.add(frame);
                i++;
                continue;
            }

            int rollTwo = rolls.get(i + 1);
            Frame frame = new Frame(rollOne, rollTwo);
            frames.add(frame);
            i+=2;
        }

        ScoreCalculator scoreCalculator = new ScoreCalculator(frames);
        return scoreCalculator.getScore();
    }
}
