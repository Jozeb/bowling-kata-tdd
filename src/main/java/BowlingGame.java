public class BowlingGame {
    private int pinsDown;
    int rollIteration = 0;
    int sumOfTwoRolls;
    boolean isStrike;
    int strikePinCounter = 0;

    public void roll(int pins) {
        pinsDown += pins;

        if(isStrike ){
            if(strikePinCounter <2){
                pinsDown += pins;
                strikePinCounter++;
            }
            else if (strikePinCounter == 2)
                isStrike = false;
        }
        else{
            if (rollIteration == 2) {
                if (sumOfTwoRolls == 10) {
                    pinsDown += pins;
                }
                rollIteration = 0;
                sumOfTwoRolls = 0;
            }
        }

        if(pins == 10){
            isStrike = true;
        }

        sumOfTwoRolls += pins;
        rollIteration++;
    }

    public int score() {
        return pinsDown;
    }
}
