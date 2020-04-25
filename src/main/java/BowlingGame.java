public class BowlingGame {

    int score;
    int last_score;
    boolean isSecondRoll;

    BowlingGame() {
        score = 0;
        last_score = 0;
        isSecondRoll = false;
    }

    public void roll(int rollPins) {

        if (last_score == 10) {
            this.score = this.score + rollPins;
        }
        
        if (isSecondRoll) {
            last_score = last_score + rollPins;
        } else {
            last_score = rollPins;
        }

        isSecondRoll = !isSecondRoll;

        this.score = this.score + rollPins;
    }

    public int score() {
        return this.score;
    }
}
