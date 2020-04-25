class BowlingGame {

    int total;

    public BowlingGame() {
        this.total = 0;
    }

    public void roll(int pins) {
        if (pins < 0) throw new AssertionError("Knocked pin count should not be negative.");

        total += pins;
    }

    public int getRunningScore() {
        return total;
    }
}