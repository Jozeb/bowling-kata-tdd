import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ScoreCalculator {
    //private int score;
    private List<Frame> frames;

    public ScoreCalculator(List<Frame> frames) {
        //frameScoringStrategy.put(FrameScoringMethod.STRIKE, ScoreCalculator::calculateForNormal);
        this.frames = frames;
    }


    Map<FrameScoringMethod, Function<Frame, Void>> frameScoringStrategy = new HashMap<>();

    public int getScore() {
        int score = 0;
        for (int i = 0; i < frames.size() - 1; i++) {
            Frame frame = frames.get(i);
            Frame nextFrame = frames.get(i + 1);

            score += calculateForStrike(frame, nextFrame);
            score +=calculateForSpare(frame, nextFrame);
            score += calculateForNormal(frame, nextFrame);

        }
        Frame frame = frames.get(9);
        score += calculateForNormal(frame, null);
        return score;
    }

    private static int calculateForNormal(Frame frame, Frame nextFrame) {
        if (frame.isNormalMove()) {
            return frame.getPinsKnockedDown();
        }
        return 0;
    }

    private int calculateForSpare(Frame frame, Frame nextFrame) {
        if (frame.isSpare()) {
            return frame.getPinsKnockedDown() + nextFrame.getSpareCount();
        }
        return 0;
    }

    private static int calculateForStrike(Frame frame, Frame nextFrame) {
        if (frame.isStrike()) {
            return frame.getPinsKnockedDown() + nextFrame.getPinsKnockedDown();
        }
        return 0;
    }


}
