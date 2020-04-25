
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

    private void computeActualFrameScore(Frame frame1, Frame frame2, Frame frame3) {

        if(frame1.isStrike()) {
            if(!frame2.isStrike()) {
                frame1.addScore(frame2.getRoll1().get() + frame2.getRoll2().get());
            }
            else {
                frame1.addScore(10 + frame3.getRoll1().get());
            }
        }

        if(frame1.isSpare()) {
            frame1.addScore(frame2.getRoll1().get());
        }



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

        for(int i=0 ; i<8 ; i++) {
            computeActualFrameScore(frames.get(i), frames.get(i+1), frames.get(i+2));
        }
       return frames.stream().mapToInt(Frame::getScore).sum();
    }
}
