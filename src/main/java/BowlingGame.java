import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int pinsDown;
    int rollIteration = 0;
    int sumOfTwoRolls;
    boolean isStrike;
    int strikePinCounter = 0;

    List frames = new ArrayList();

    public void roll(int pins) {

        if (rollIteration == 2 && sumOfTwoRolls < 10) {
            frames.add(new Frame(sumOfTwoRolls, ScoreType.NORMAL));
        }

        pinsDown += pins;

        if(isStrike){
            handleAfterStrike(pins);
        } else if (rollIteration == 2) {
            handleAfterSpare(pins);
        }

        if(pins == 10){
            isStrike = true;
        }

        sumOfTwoRolls += pins;
        rollIteration++;
    }

    private void handleAfterSpare(int pins) {
        if (sumOfTwoRolls == 10) {
            pinsDown += pins;
        }
        rollIteration = 0;
        sumOfTwoRolls = 0;
    }

    private void handleAfterStrike(int pins) {
        if(strikePinCounter <2){
            pinsDown += pins;
            strikePinCounter++;
        }
        else if (strikePinCounter == 2)
            isStrike = false;
    }

    public int score() {
        return pinsDown;
    }
}
