public class BowlingGame {

    int[] frames = {0,0,0};
    int currentFrame = 0;
    int score = 0;

    public void roll(int pins) {
        score += pins;

        if (frames[currentFrame] == 10) {
            score += pins;
            currentFrame++;
        }

        frames[currentFrame] += pins;
    }

    public int score() {
        return score;
    }
}
