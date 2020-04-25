public class BowlingGame {

    int score;

    public void roll(int rollPins) {
        this.score = this.score + rollPins;
    }

    public int score() {
        return this.score;
    }
}
