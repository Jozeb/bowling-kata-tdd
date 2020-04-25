public class BowlingGame {

    int score;
    int lastScore;
    int currentScore;
    boolean isLastFrameStrike;
    int strikeHandled;
    boolean isSecondRoll;

    BowlingGame() {
        score = 0;
        lastScore = 0;
        currentScore = 0;
        strikeHandled = 0;
        isSecondRoll = false;
        isLastFrameStrike = false;
    }

    public void roll(int rollPins) {

        if (isLastFrameStrike) {
//            strike
            if (strikeHandled < 2) score = score + rollPins;
            strikeHandled++;
            if (strikeHandled == 2) {
                isLastFrameStrike = false;
                strikeHandled = 0;
            }
        } else {
//            spare
            if (lastScore == 10) {
                this.score = this.score + rollPins;
            }

            if (isSecondRoll) {
                lastScore = lastScore + rollPins;
            } else {
                lastScore = rollPins;
            }
        }

        if (rollPins != 10) {
            isSecondRoll = !isSecondRoll;
        }

        this.score = this.score + rollPins;

        if (rollPins == 10) {
            isLastFrameStrike = true;
            strikeHandled = 0;
        }
    }

    public int score() {
        return this.score;
    }
}
