public class BowlingGame {

    int previousFrame;
    int score = 0;

    public void roll(int pins) {
        score += pins;

        if (previousFrame == 10) {
            score += pins;
        }

        previousFrame += pins;
    }

    public int score() {
        return score;
    }
}
