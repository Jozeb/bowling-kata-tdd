import Domain.Pin;
import Domain.Score;

public class BowlingGame {
    Score currentScore = new Score();

    public void roll(Pin pin) {
        currentScore.add(pin);
    }

    public Score score() {
        return currentScore;
    }

}
