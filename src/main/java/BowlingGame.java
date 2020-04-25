import Domain.Frames;
import Domain.Pin;
import Domain.Score;
import Exception.*;

public class BowlingGame {

    Frames frames = new Frames();
    Score currentScore = new Score();

    public void roll(Pin pin) throws InvalidFrameException {
        currentScore.add(pin);
        frames.add(pin);
    }

    public Score score() {
        return currentScore;
    }

}
