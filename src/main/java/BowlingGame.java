import com.sun.tools.classfile.StackMapTable_attribute;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int pinsDown;
    int rollIteration = 0;
    int sumOfTwoRolls;
    boolean isStrike;
    int strikePinCounter = 0;



    private List<Frame> frames = new ArrayList(){{add(new Frame());}};



    public void roll(int pins) {

        Frame lastFrame = frames.get(frames.size()-1);

        if(lastFrame.isFrameCompleted()){
            lastFrame = new Frame();
            frames.add(lastFrame);
        }
        lastFrame.add(pins);

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
