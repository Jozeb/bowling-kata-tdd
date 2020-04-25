public class BowlingGame {
    private int pinsDown;
    int rollIteration = 0;
    int sumOfTwoRolls;

    public void roll(int pins) {
        pinsDown += pins;

        if (rollIteration == 2) {
            if (sumOfTwoRolls == 10) {
                pinsDown += pins;
            }
            rollIteration = 0;
            sumOfTwoRolls = 0;
        }
        sumOfTwoRolls += pins;
        rollIteration++;
    }

    public int score() {
        return pinsDown;
    }
}
