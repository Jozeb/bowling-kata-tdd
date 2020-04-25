import java.util.List;

public class ScoreCalculator {
    private int score;

    public ScoreCalculator() {
        score = 0;
    }

    public int getScore(List<Frame> frames) {
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if (frame.isSpare()) {
                Frame nextFrame = frames.get(i + 1);
                score += frame.getPinsKnockedDown() + nextFrame.getSpareCount();
                continue;
            }
            score += frame.getPinsKnockedDown();
        }
        return score;
    }


}
