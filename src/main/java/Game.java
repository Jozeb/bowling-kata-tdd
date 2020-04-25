import exceptions.GameHasEndedException;
import exceptions.InvalidRollException;

import java.util.ArrayList;

public class Game {

    private int rollsCount;

    private ArrayList<Integer> rolls;

    public Game() {
        this.rolls = new ArrayList<>();
    }

    public void roll(int i) throws GameHasEndedException, InvalidRollException {

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
        ArrayList<Frame> frames = new ArrayList<Frame>();
        for (int i = 0; i < rolls.size(); i+=2) {
            int rollOne = rolls.get(i);
            int rollTwo = rolls.get(i + 1);
            Frame frame = new Frame(rollOne, rollTwo);
            frames.add(frame);
        }
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        return scoreCalculator.getScore(frames);
    }
}
