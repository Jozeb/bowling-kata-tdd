public class BowlingGame {

    int score;
    int lastScore;
    boolean isLastFrameSpare;
    boolean isLastFrameStrike;
    int strikesHandled;
    boolean isSecondRoll;
    int currentFrame;

    BowlingGame() {
        score = 0;
        lastScore = 0;
        strikesHandled = 0;
        isSecondRoll = false;
        isLastFrameSpare = false;
        isLastFrameStrike = false;
        currentFrame = 1;
    }

    public void roll(int rollPins) {
        if(this.currentFrame == 11){
            throw new GameOverException();
        }
        if (isLastFrameStrike) {
            handleLastStrikeCase(rollPins);
        } else if (isLastFrameSpare) {
            handleLastSpareCase(rollPins);
        }

        checkSpareCase(rollPins);
        checkStrikeCase(rollPins);

        this.score = this.score + rollPins;
        lastScore = rollPins;
    }

    private void checkStrikeCase(int rollPins) {
        if (isAllPinsDown(rollPins)) {
            isLastFrameStrike = true;
            strikesHandled = 0;
            isSecondRoll = false;
            currentFrame++;
        }
    }

    private boolean isAllPinsDown(int rollPins) {
        return rollPins == 10;
    }

    private void checkSpareCase(int rollPins) {
        if (isSecondRoll) {
            if (lastScore + rollPins == 10) {
                isLastFrameSpare = true;
            }
            currentFrame++;
        }
        isSecondRoll = !isSecondRoll;
    }

    private void handleLastSpareCase(int rollPins) {
        this.score = this.score + rollPins;
        isLastFrameSpare = false;
    }

    private void handleLastStrikeCase(int rollPins) {
        if (strikesHandled < 2) score = score + rollPins;
        strikesHandled++;
        if (strikesHandled == 2) {
            isLastFrameStrike = false;
            strikesHandled = 0;
        }
    }

    public int score() {
        return this.score;
    }
}
