import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javafx.util.Pair;

public class ScoreCalculator {

    private List<Frame> frames;
    Map<FrameScoringMethod, Function<Pair<Frame,Frame>, Integer>> frameScoringStrategy = new HashMap<>();

    public ScoreCalculator(List<Frame> frames) {
        frameScoringStrategy.put(FrameScoringMethod.STRIKE, ScoreCalculator::calculateForStrike);
        frameScoringStrategy.put(FrameScoringMethod.SPARE, ScoreCalculator::calculateForSpare);
        frameScoringStrategy.put(FrameScoringMethod.NORMAL, ScoreCalculator::calculateForNormal);
        this.frames = frames;
    }



    public int getScore() {
        int score = 0;
        for (int i = 0; i < frames.size() - 1; i++) {
            Frame frame = frames.get(i);
            Frame nextFrame = frames.get(i + 1);

            FrameScoringMethod frameScoringMethod = FrameHelper.getframeScoringMethod(frame);
            score += frameScoringStrategy.get(frameScoringMethod).apply(new Pair<>(frame, nextFrame));



        }
        Frame frame = frames.get(9);
        score += calculateForNormal(new Pair<>(frame, null));
        return score;
    }

    private static int calculateForNormal(Pair<Frame,Frame> frameScoringPair) {
        Frame frame = frameScoringPair.getKey();
        if (frame.isNormalMove()) {
            return frame.getPinsKnockedDown();
        }
        return 0;
    }

    private static int calculateForSpare(Pair<Frame, Frame> frameScoringPair) {
        Frame frame = frameScoringPair.getKey();
        Frame nextFrame = frameScoringPair.getValue();
        if (frame.isSpare()) {
            return frame.getPinsKnockedDown() + nextFrame.getSpareCount();
        }
        return 0;
    }

    private static int calculateForStrike(Pair<Frame,Frame> frameScoringPair) {
        Frame frame = frameScoringPair.getKey();
        Frame nextFrame = frameScoringPair.getValue();
        if (frame.isStrike()) {
            return frame.getPinsKnockedDown() + nextFrame.getPinsKnockedDown();
        }
        return 0;
    }


}
