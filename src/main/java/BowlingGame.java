class BowlingGame {

    int runningScore;

    public BowlingGame() {
        this.runningScore = 0;
    }

    public void roll(KnockedPinCount knockedPinCount) {
        runningScore += knockedPinCount.getCount();
    }

    public int getRunningScore() {
        return runningScore;
    }
}