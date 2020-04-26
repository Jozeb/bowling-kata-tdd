public class BowlingGame {

    int score = 0;
    public void roll(int pinsDown) {
        score += pinsDown;
    }

    public int score() {
        return score;
    }
}
